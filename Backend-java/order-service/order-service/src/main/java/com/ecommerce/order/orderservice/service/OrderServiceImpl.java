package com.ecommerce.order.orderservice.service;

import com.ecommerce.order.orderservice.exception.NotFoundException;
import com.ecommerce.order.orderservice.model.Order;
import com.ecommerce.order.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository= orderRepository;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {



        Optional<Order> order = orderRepository.findById(orderId);
        if (!order.isPresent()){
            throw new NotFoundException("this order is not found");
        }
        return order.get();
    }

    @Override
    public List<Order> getAllOrder() {

        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()){
            throw new NotFoundException("no data present in database");
        }
        return orders;
    }

    @Override
    public Order updateOrder(long orderId, Order order) {



        Optional<Order> orderFromDB = orderRepository.findById(orderId);
        if (!orderFromDB.isPresent()){
            throw new NotFoundException("this order is not found");
        }
        orderFromDB.get().setOrderDescription(order.getOrderDescription());
        orderFromDB.get().setOrderPrice(order.getOrderPrice());
        orderFromDB.get().setQuantity(order.getQuantity());
        orderFromDB.get().setProductId(order.getProductId());

        Order updatedOrder = orderRepository.save(orderFromDB.get());

        return updatedOrder;
    }

    @Override
    public Boolean deleteOrder(Long orderId) {
      Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()){
            throw new NotFoundException("this Order id is not present in database");
        }
        return true;
    }
}
