package com.example.productserviceapr24.exceptions;

public class ProductLimitReachedException extends Exception {
    public ProductLimitReachedException(String message)
    {
        super(message);
    }
}
