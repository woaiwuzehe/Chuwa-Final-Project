package com.example.payment_service.controller;

import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.entities.Payment;
import com.example.payment_service.payload.RefundPaymentRequest;
import com.example.payment_service.payload.SubmitPaymentRequest;
import com.example.payment_service.payload.UpdatePaymentRequest;
import com.example.payment_service.service.PaymentService;
import com.example.payment_service.util.PaymentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 提交支付
    @PostMapping("/submit")
    public ResponseEntity<PaymentDTO> submitPayment(@RequestBody SubmitPaymentRequest request) {
        UUID orderId = UUID.fromString(request.getOrderId());
        Payment payment = paymentService.submitPayment(orderId, request.getAmount());
        return ResponseEntity.ok(PaymentConverter.toDTO(payment));
    }

    // 更新支付信息
    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> updatePayment(
            @PathVariable String paymentId,
            @RequestBody UpdatePaymentRequest request) {
        UUID pid = UUID.fromString(paymentId);
        Optional<Payment> updated = paymentService.updatePayment(pid, request.getStatus(), request.getAmount());
        return updated.map(p -> ResponseEntity.ok(PaymentConverter.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 退款操作
    @PostMapping("/{paymentId}/refund")
    public ResponseEntity<PaymentDTO> refundPayment(
            @PathVariable String paymentId,
            @RequestBody RefundPaymentRequest request) {
        UUID pid = UUID.fromString(paymentId);
        Optional<Payment> refunded = paymentService.refundPayment(pid, request.getRefundAmount());
        return refunded.map(p -> ResponseEntity.ok(PaymentConverter.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 查询支付记录
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable String paymentId) {
        UUID pid = UUID.fromString(paymentId);
        Optional<Payment> paymentOpt = paymentService.getPaymentById(pid);
        return paymentOpt.map(p -> ResponseEntity.ok(PaymentConverter.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }
}
