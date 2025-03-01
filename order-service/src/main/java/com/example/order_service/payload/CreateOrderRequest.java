package com.example.order_service.payload;

public class CreateOrderRequest {
    private String customerId;
    private double totalAmount;

    // add more like address, item...

    // Getter and Setter
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
