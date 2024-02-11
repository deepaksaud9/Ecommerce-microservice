package com.ecommerce.order.orderservice.repository;

import com.ecommerce.order.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderDescription(String description);
}
