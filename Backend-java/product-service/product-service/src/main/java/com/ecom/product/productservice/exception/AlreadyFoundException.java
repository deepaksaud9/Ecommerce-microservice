package com.ecom.product.productservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AlreadyFoundException extends RuntimeException{

    private int statusCode;
    private String message;

    public AlreadyFoundException(String message){
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }
}
