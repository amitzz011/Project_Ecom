package com.batchten.ecom.service;

import com.batchten.ecom.model.Product;
import com.batchten.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{



    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String createProduct(Product product) {
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
        return "New Product created";

    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    @Override
    public String updateProductById(Integer id, BigDecimal price , Integer quantity) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            Product product = optional.get();
            product.setPrice(price);
            product.setQuantity(quantity);
            productRepository.save(product);

        }

        return "Product Updated";
    }

    @Override
    public String deleteProductById(Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent())
            productRepository.deleteById(id);

        return "Product record is deleted";
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return productRepository.searchProducts(keyword);

    }
}
