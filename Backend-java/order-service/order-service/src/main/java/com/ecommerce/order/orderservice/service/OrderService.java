package com.ecommerce.order.orderservice.service;

import com.ecommerce.order.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrder();

    Order updateOrder(long orderId, Order order);

    Boolean deleteOrder(Long orderId);
}
