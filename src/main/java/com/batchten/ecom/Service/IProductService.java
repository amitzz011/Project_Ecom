package com.batchten.ecom.Service;

import com.batchten.ecom.Model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    String createProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProduct();
    String updateProductById(Integer id, BigDecimal price, Integer quantity, Boolean productAvailable);
    String deleteProductById(Integer id);
    List<Product> searchProduct(String keyword);
}
