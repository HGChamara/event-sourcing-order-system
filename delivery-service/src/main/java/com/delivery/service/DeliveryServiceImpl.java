package com.delivery.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryServiceImpl {

    public void consumeOrderEvent(Object orderEvent) {

    }

    public void shipOrder(UUID orderId) {

    }

    public void deliverOrder(UUID orderId) {

    }

    private void saveAndPublishShippingEvents(Object event) {

    }
}
