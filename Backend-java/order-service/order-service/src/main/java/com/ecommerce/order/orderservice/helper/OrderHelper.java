package com.ecommerce.order.orderservice.helper;

import com.ecom.common.dto.OrderResponse;
import com.ecom.common.dto.ProductResponse;
import com.ecommerce.order.orderservice.model.Order;

public class OrderHelper {

    public static OrderResponse orderToOrderResponse(Order order, ProductResponse productResponse){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setOrderDescription(order.getOrderDescription());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setOrderPrice(order.getOrderPrice());
        orderResponse.setProductResponse(productResponse);

        return orderResponse;
    }
}
