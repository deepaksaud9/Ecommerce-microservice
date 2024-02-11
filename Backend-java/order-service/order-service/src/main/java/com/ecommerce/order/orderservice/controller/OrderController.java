package com.ecommerce.order.orderservice.controller;

import com.ecommerce.order.orderservice.model.Order;
import com.ecommerce.order.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        Order createdOrder= orderService.addOrder(order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>>  getAllOrders(){

        List<Order> orders = orderService.getAllOrder();

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId){

       Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable long orderId, @RequestBody Order order){

        Order updatedOrder = orderService.updateOrder(orderId,order);

        return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId){

        orderService.deleteOrder(orderId);

        return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
    }

}
