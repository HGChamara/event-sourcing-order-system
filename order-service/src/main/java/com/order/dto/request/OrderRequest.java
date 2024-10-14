package com.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private UUID orderId;
    private String name;
    private int quantity;
    private double price;
    private UUID userId;
}
