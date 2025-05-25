package com.batchten.ecom.controller;

import com.batchten.ecom.dto.ProductDto;
import com.batchten.ecom.model.Product;
import com.batchten.ecom.repository.ProductRepository;
import com.batchten.ecom.service.IProductService;
import com.batchten.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    private IProductService productService;

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);

        //return new ResponseEntity<>(HttpStatus.OK, "Created Successfully");
        return new ResponseEntity<>("Data Inserted Successfully", HttpStatus.OK);

//        Product savedProduct = productRepository.save(product);

//        URI location = URI.create("/api/product/" + savedProduct.getId());
//        return ResponseEntity.created(location).body(savedProduct);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("Entering into getAllProducts......");
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);


    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {

        Product product = productService.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestBody BigDecimal price, @RequestBody Integer quantity) {
        productService.updateProductById(id,price,quantity);
        return new ResponseEntity<>("Product Updated successfully", HttpStatus.OK);

    }



    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable ("id") Integer id) {

        String res = productService.deleteProductById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

//    @GetMapping("/searchProduct/{keyword}")
//    public ResponseEntity<String> searchProduct (@PathVariable(value = "keyword") String keyword){
//        System.out.print("Entering into search product API....");
//        List<Product> products = productService.searchProduct(keyword);
//
//        return new ResponseEntity<>("Search Product successfully",HttpStatus.OK);
//
//
//    }


//    @GetMapping("/products/search/{keyword}")
//    public ResponseEntity<List<Product>> searchProduct(@PathVariable String keyword) {
//        System.out.println("Searching for: " + keyword);
//        List<Product> products = productService.searchProduct(keyword);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam (value = "name")String keyword){
        List<Product> products = productService.searchProduct(keyword);
        System.out.println("searching with " + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
