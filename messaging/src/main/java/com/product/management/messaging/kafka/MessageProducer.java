package com.product.management.messaging.kafka;

public interface MessageProducer {
    void sendMessage(Object product);
}
