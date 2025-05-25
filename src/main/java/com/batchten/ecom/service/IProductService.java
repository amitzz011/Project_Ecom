package com.batchten.ecom.service;

import com.batchten.ecom.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {

    String createProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProduct();
    String updateProductById(Integer id, BigDecimal price , Integer quantity);
    String deleteProductById(Integer id);
    List<Product> searchProduct(String keyword);

}
