package com.batchten.ecom.controller;


import com.batchten.ecom.dto.ProductDto;
import com.batchten.ecom.model.Product;
import com.batchten.ecom.repository.ProductRepository;
import com.batchten.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<String> createProduct( @RequestBody Product product){
         productService.createProduct(product);

         //return new ResponseEntity<>(HttpStatus.OK, "Created Successfully");
        return new ResponseEntity<>("Data Inserted Successfully", HttpStatus.OK);

//        Product savedProduct = productRepository.save(product);

//        URI location = URI.create("/api/product/" + savedProduct.getId());
//        return ResponseEntity.created(location).body(savedProduct);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);


    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id")Integer id){

        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }



}
