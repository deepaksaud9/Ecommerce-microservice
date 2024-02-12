package com.ecommerce.order.orderservice.controller;

import com.ecom.common.dto.OrderResponse;
import com.ecom.common.dto.ProductResponse;
import com.ecommerce.order.orderservice.feign.ProductService;
import com.ecommerce.order.orderservice.helper.OrderHelper;
import com.ecommerce.order.orderservice.model.Order;
import com.ecommerce.order.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    OrderController(OrderService orderService, ProductService productService){
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        Order createdOrder= orderService.addOrder(order);

        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderResponse>>  getAllOrders(){

        List<OrderResponse> orders = orderService.getAllOrder().stream().map(e ->
                OrderHelper.orderToOrderResponse(e,this.productService.getProductById(e.getProductId()).getBody())).collect(Collectors.toList());

        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable long orderId){

        Order order = this.orderService.getOrderById(orderId);
        ProductResponse product = this.productService.getProductById(order.getProductId()).getBody();

       OrderResponse orderResponse = OrderHelper.orderToOrderResponse(order,product);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
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
