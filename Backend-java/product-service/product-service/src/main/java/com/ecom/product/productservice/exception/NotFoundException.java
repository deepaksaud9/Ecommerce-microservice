package com.ecom.product.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException{

    private int statusCode;
    private String message;

    public NotFoundException(String message){
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }
}
