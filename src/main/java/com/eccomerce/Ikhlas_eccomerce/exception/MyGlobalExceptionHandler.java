package com.eccomerce.Ikhlas_eccomerce.exception;

import com.eccomerce.Ikhlas_eccomerce.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class MyGlobalExceptionHandler {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })

    public ResponseEntity< Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);
        });
                return new ResponseEntity<Map<String, String>>(response,
                        HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<ApiResponse> myResourceNotFoundException(ResourceNotFoundException e) {
    String message = e.getMessage();
    ApiResponse apiResponse = new ApiResponse(message, false);
    return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { ApiExceptions.class })
    public ResponseEntity<ApiResponse> ApiExceptions(ApiExceptions e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
