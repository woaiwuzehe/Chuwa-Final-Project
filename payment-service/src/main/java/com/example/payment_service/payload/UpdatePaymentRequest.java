package com.example.payment_service.payload;

public class UpdatePaymentRequest {
    private String status;
    private double amount;

    // Getter and Setter
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

