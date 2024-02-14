package com.ecom.userservice.handler;

import com.ecom.userservice.exception.AlreadyFoundException;
import com.ecom.userservice.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler extends RuntimeException{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notFoundException(NotFoundException notFoundException){

        ApiResponse apiResponse = new ApiResponse(notFoundException.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFoundException.class)
    ResponseEntity<ApiResponse> alreadyFoundException(AlreadyFoundException alreadyFoundException){

        ApiResponse apiResponse = new ApiResponse(alreadyFoundException.getMessage(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}


