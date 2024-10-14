package com.order.service;

import com.order.dto.request.OrderRequest;
import com.order.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);
    OrderResponse confirmOrder(UUID orderId);
}
