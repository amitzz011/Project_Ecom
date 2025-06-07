package com.batchten.ecom.Controller;

import com.batchten.ecom.Model.Product;
import com.batchten.ecom.Service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name="Ecom product Management API controller",description = "This api will manage your Product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Operation(summary = "POST Operation",description = "This API will add your new Product")
    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }
    @Operation(summary = "GET Operation",description = "This API will Get all Product")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
    @Operation(summary = "GET Operation",description = "This API will get Product by ID")
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @Operation(summary = "PUT Operation",description = "This API will update existing Product")
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable Integer id,
            @RequestParam BigDecimal price,
            @RequestParam Integer quantity,
            @RequestParam Boolean productAvailable)
    {
        productService.updateProductById(id, price, quantity , productAvailable);
        return ResponseEntity.ok("Product updated successfully");
    }
    @Operation(summary = "DELETE Operation",description = "This API will delete the Product")
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        String result = productService.deleteProductById(id);
        return ResponseEntity.ok(result);
    }
    @Operation(summary = "GET Operation",description = "This API will search Product")
    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("name") String keyword) {
        List<Product> products = productService.searchProduct(keyword);
        return ResponseEntity.ok(products);
    }
}
