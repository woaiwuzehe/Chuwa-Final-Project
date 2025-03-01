package com.example.order_service.service;

import com.example.order_service.dao.OrderRepository;
import com.example.order_service.entities.Order;
import com.example.order_service.kafka.OrderKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderKafkaProducer orderKafkaProducer;

    // 创建订单：设置订单状态为 "CREATED"，发送 Kafka 消息
    public Order createOrder(UUID customerId, double totalAmount) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID());
        order.setCustomerId(customerId);
        order.setOrderDate(Instant.now());
        order.setStatus("CREATED");
        order.setTotalAmount(totalAmount);
        Order savedOrder = orderRepository.save(order);
        // 发送创建订单的 Kafka 消息
        orderKafkaProducer.sendOrderMessage("Order Created: " + savedOrder.getOrderId());
        return savedOrder;
    }

    // 更新订单状态
    public Optional<Order> updateOrder(UUID orderId, String newStatus, double totalAmount) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if(orderOpt.isPresent()){
            Order order = orderOpt.get();
            order.setStatus(newStatus);
            order.setTotalAmount(totalAmount);
            Order updatedOrder = orderRepository.save(order);
            // 发送更新订单的 Kafka 消息
            orderKafkaProducer.sendOrderMessage("Order Updated: " + updatedOrder.getOrderId() + ", status: " + newStatus);
            return Optional.of(updatedOrder);
        }
        return Optional.empty();
    }

    // 取消订单
    public Optional<Order> cancelOrder(UUID orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if(orderOpt.isPresent()){
            Order order = orderOpt.get();
            order.setStatus("CANCELLED");
            Order cancelledOrder = orderRepository.save(order);
            // 发送取消订单的 Kafka 消息
            orderKafkaProducer.sendOrderMessage("Order Cancelled: " + cancelledOrder.getOrderId());
            return Optional.of(cancelledOrder);
        }
        return Optional.empty();
    }

    // 根据客户 ID 查找订单
    public List<Order> findOrdersByCustomer(UUID customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // 根据订单 ID 查询订单
    public Optional<Order> getOrderById(UUID orderId) {
        return orderRepository.findById(orderId);
    }
}

