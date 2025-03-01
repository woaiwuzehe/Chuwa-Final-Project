package com.example.order_service.dto;

import java.time.Instant;
import java.util.UUID;

public class OrderDTO {

    private UUID orderId;
    private UUID customerId;
    private Instant orderDate;
    private String status;
    private double totalAmount;

    // Getter 和 Setter
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
