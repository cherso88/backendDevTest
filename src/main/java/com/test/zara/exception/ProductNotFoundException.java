package com.test.zara.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message, int value) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ProductNotFoundException(String s) {
        super(s);
    }
}
