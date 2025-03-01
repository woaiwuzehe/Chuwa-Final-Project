package com.example.payment_service.payload;

public class RefundPaymentRequest {
    private String orderId;
    private double refundAmount;
    private String reason;

    // Getter and Setter
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public double getRefundAmount() {
        return refundAmount;
    }
    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}
