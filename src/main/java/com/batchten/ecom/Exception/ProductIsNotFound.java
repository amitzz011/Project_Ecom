package com.batchten.ecom.Exception;

public class ProductIsNotFound extends RuntimeException {
    public ProductIsNotFound(String msg) {
        super(msg);
    }
}
