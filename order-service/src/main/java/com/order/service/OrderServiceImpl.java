package com.order.service;

import com.order.dto.enums.OrderStatus;
import com.order.dto.request.OrderRequest;
import com.order.dto.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    public OrderResponse placeOrder(OrderRequest request) {
        return new OrderResponse(UUID.randomUUID(), OrderStatus.CREATED);
    }

    public OrderResponse confirmOrder(UUID orderId) {
        return new OrderResponse(orderId, OrderStatus.CONFIRMED);
    }
}
