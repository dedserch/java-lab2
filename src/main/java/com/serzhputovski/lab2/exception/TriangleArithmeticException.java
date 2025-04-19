package com.serzhputovski.lab2.exception;

public class TriangleArithmeticException extends RuntimeException {
    public TriangleArithmeticException(String message) {
        super(message);
    }

    public TriangleArithmeticException(String message, Throwable cause) {
        super(message, cause);
    }
}