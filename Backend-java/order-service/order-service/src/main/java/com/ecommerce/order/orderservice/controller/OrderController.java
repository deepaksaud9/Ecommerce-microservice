package com.ecommerce.order.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @GetMapping("/test")
    public ResponseEntity<String> testing(){

        return new ResponseEntity<>("working fine", HttpStatus.OK);
    }

}
