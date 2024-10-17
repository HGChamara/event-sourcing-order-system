package com.order.service;

import com.order.dto.enums.OrderStatus;
import com.order.dto.request.OrderRequest;
import com.order.dto.response.OrderResponse;
import com.order.entity.OrderEvent;
import com.order.publisher.OrderEventPublisher;
import com.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher publisher;
    public OrderResponse placeOrder(OrderRequest request) {
        UUID orderId = UUID.randomUUID();
        OrderEvent event = new OrderEvent(orderId, OrderStatus.CREATED, "Order placed", LocalDateTime.now());
        saveAndPublishEvents(event);
        return new OrderResponse(orderId, OrderStatus.CREATED);
    }

    public OrderResponse confirmOrder(UUID orderId) {
        OrderEvent event = new OrderEvent(orderId, OrderStatus.CONFIRMED, "Order confirmed", LocalDateTime.now());
        saveAndPublishEvents(event);
        return new OrderResponse(orderId, OrderStatus.CONFIRMED);
    }

    private void saveAndPublishEvents(OrderEvent event) {
        orderRepository.save(event);
        publisher.sendOrderEvent(event);
    }
}
