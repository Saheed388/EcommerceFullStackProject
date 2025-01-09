package com.eccomerce.Ikhlas_eccomerce.exception;

public class ApiExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApiExceptions() {
    }

    public ApiExceptions(String message) {
        super(message);
    }
}
