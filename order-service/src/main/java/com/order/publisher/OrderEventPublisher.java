package com.order.publisher;

import com.order.entity.OrderEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    public OrderEventPublisher(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Value("${topicName}")
    private String topicName;

    public void sendOrderEvent(OrderEvent orderEvent) {
        kafkaTemplate.send(topicName, orderEvent);
    }

}
