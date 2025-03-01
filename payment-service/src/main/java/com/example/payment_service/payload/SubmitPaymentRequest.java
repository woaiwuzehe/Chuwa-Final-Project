package com.example.payment_service.payload;

public class SubmitPaymentRequest {
    private String orderId;
    private double amount;


    // Getter and Setter
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
