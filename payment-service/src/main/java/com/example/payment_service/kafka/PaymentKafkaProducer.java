package com.example.payment_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "payment-topic"; // set message topic

    @Autowired
    public PaymentKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}

