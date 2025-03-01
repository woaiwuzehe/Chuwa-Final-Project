package com.example.order_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaConsumer {

    @KafkaListener(topics = "order-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        System.out.println("Received order message: " + message);
        // 根据消息内容可以进一步处理，例如更新订单状态等
    }
}

