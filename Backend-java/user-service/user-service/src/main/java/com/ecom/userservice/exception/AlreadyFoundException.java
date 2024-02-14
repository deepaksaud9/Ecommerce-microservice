package com.ecom.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlreadyFoundException extends RuntimeException{

    private String message;
    private int statusCode;

    AlreadyFoundException(String message){
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }
}
