package com.example.order_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//在订单业务中调用 KafkaTemplate 发送订单消息
@Component
public class OrderKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "order-topic"; // 根据实际情况设置topic

    @Autowired
    public OrderKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}
