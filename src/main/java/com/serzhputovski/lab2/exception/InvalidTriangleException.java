package com.serzhputovski.lab2.exception;

public class InvalidTriangleException extends Exception {
    public InvalidTriangleException(String message) {
        super(message);
    }

    public InvalidTriangleException(String message, Throwable cause) {
        super(message, cause);
    }
}
