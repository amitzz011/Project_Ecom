package com.batchten.ecom.controller;


import com.batchten.ecom.dto.ProductDto;
import com.batchten.ecom.model.Product;
import com.batchten.ecom.repository.ProductRepository;
import com.batchten.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @PostMapping("/product")
    public ResponseEntity<Product> createProduct( @RequestBody Product product){
        Product savedProduct = productRepository.save(product);

        // Return HTTP 201 Created with the URI of the created resource
        URI location = URI.create("/api/product/" + savedProduct.getId());
        return ResponseEntity.created(location).body(savedProduct);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);


    }


}
