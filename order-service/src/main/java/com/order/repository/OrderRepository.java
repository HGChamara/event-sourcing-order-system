package com.order.repository;

import com.order.entity.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEvent, String> {
}
