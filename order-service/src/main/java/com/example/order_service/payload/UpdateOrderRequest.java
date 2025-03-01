package com.example.order_service.payload;

public class UpdateOrderRequest {
    private String status;
    private double totalAmount;

    // Getter and Setter
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

