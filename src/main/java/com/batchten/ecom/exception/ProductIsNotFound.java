package com.batchten.ecom.exception;

public class ProductIsNotFound extends RuntimeException{

    public ProductIsNotFound(String msg){
        super(msg);
    }
}
