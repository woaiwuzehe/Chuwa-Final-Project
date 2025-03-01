package com.example.payment_service.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID orderId;          // 关联订单ID

    @Column(nullable = false)
    private double amount;         // 支付金额

    @Column(nullable = false)
    private String status;         // 支付状态: SUBMITTED, COMPLETED, REFUNDED

    @Column(nullable = false)
    private Instant timestamp;     // 支付时间

    public Payment() {}

    public Payment(UUID orderId, double amount, String status, Instant timestamp) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getter 和 Setter
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getOrderId() {
        return orderId;
    }
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}

