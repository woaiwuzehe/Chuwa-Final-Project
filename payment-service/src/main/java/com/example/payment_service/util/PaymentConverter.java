package com.example.payment_service.util;

import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.entities.Payment;

public class PaymentConverter {

    public static PaymentDTO toDTO(Payment payment) {
        if (payment == null) {
            return null;
        }
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        dto.setTimestamp(payment.getTimestamp());
        return dto;
    }
}
