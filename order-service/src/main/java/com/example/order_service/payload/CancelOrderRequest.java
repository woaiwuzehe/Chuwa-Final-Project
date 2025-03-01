package com.example.order_service.payload;

public class CancelOrderRequest {
    private String reason;

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}

