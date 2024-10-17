package com.order.entity;

import com.order.dto.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "OrderEvents")
public class OrderEvent {

    public OrderEvent(UUID orderId, OrderStatus status, String details, LocalDateTime eventTimestamp) {
        this.id = UUID.randomUUID();
        this.orderId = orderId;
        this.status = status;
        this.details = details;
        this.eventTimestamp = eventTimestamp;
    }

    @Id
    private UUID id;
    private UUID orderId;
    private OrderStatus status;
    private String details;
    private LocalDateTime eventTimestamp;
}
