package com.example.order_service.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.time.Instant;
import java.util.UUID;

@Table("orders")
public class Order {

    @PrimaryKey
    private UUID orderId;              // 订单 ID

    private UUID customerId;           // 客户 ID
    private Instant orderDate;         // 订单创建时间
    private String status;             // 订单状态 (CREATED, PAID, COMPLETED, CANCELLED)
    private double totalAmount;        // 总金额

    public Order() {}

    public Order(UUID orderId, UUID customerId, Instant orderDate, String status, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getter and Setter
    public UUID getOrderId() {
        return orderId;
    }
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
    public UUID getCustomerId() {
        return customerId;
    }
    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
    public Instant getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
