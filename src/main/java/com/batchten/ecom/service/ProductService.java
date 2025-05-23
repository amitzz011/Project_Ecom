package com.batchten.ecom.service;

import com.batchten.ecom.dto.ProductDto;
import com.batchten.ecom.model.Product;
import com.batchten.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        public void createProduct(Product product){
//            Product product = new Product();
//            product.setId(productDto.getId());
//            product.setName(productDto.getName());
//            product.setPrice(productDto.getPrice());
//            product.setBrand(productDto.getBrand());
//            product.setCategory(productDto.getCategory());
//            product.setQuantity(productDto.getQuantity());
//            product.setReleaseDate(productDto.getReleaseDate());
//            product.setProductAvailable(productDto.isProductAvailable());
//            product.setDescription(productDto.getDescription());

            productRepository.save(product);

        }

        public List<Product> getAllProduct(){

            return productRepository.findAll();
        }




}
