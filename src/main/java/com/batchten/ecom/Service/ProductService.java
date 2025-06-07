package com.batchten.ecom.Service;

import com.batchten.ecom.Exception.ProductIsNotFound;
import com.batchten.ecom.Model.Product;
import com.batchten.ecom.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "New Product created";
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductIsNotFound("Product ID " + id + " not found");
        }
    }


    @Override
    public String updateProductById(Integer id, BigDecimal price, Integer quantity ,Boolean productAvailable) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setProductAvailable(productAvailable);
            productRepository.save(product);
            return "Product updated";
        } else {
            throw new ProductIsNotFound("Product ID " + id + " not found");
        }
    }


    @Override
    public String deleteProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
            return "Product deleted";
        } else {
            throw new ProductIsNotFound("Product ID " + id + " not found");
        }
    }


    @Override
    public List<Product> searchProduct(String keyword) {
        return productRepository.searchProducts(keyword);

    }
}
