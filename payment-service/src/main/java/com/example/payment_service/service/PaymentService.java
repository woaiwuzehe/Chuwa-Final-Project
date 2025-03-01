package com.example.payment_service.service;

import com.example.payment_service.dao.PaymentRepository;
import com.example.payment_service.entities.Payment;
import com.example.payment_service.kafka.PaymentKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentKafkaProducer paymentKafkaProducer;

    @Autowired
    private RestTemplate restTemplate; // 用于与 Order Service 集成

    // 提交支付，幂等性：如果订单已支付，则返回现有记录
    public Payment submitPayment(UUID orderId, double amount) {
        Payment existing = paymentRepository.findByOrderId(orderId);
        if(existing != null && "COMPLETED".equalsIgnoreCase(existing.getStatus())){
            return existing;
        }
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("SUBMITTED");
        payment.setTimestamp(Instant.now());
        Payment saved = paymentRepository.save(payment);
        paymentKafkaProducer.sendPaymentMessage("Payment Submitted: " + saved.getId());

        // 调用 Order Service 更新订单状态（示例，实际 URL 根据情况调整）
        String orderServiceUrl = "http://localhost:8082/api/orders/" + orderId;
        // 此处可以调用 PUT 接口更新订单状态为 “PAID”
        // restTemplate.put(orderServiceUrl, ...);

        return saved;
    }

    // 更新支付信息
    public Optional<Payment> updatePayment(UUID paymentId, String newStatus, double amount) {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if(paymentOpt.isPresent()){
            Payment payment = paymentOpt.get();
            payment.setStatus(newStatus);
            payment.setAmount(amount);
            Payment updated = paymentRepository.save(payment);
            paymentKafkaProducer.sendPaymentMessage("Payment Updated: " + updated.getId() + ", status: " + newStatus);
            return Optional.of(updated);
        }
        return Optional.empty();
    }

    // 退款操作
    public Optional<Payment> refundPayment(UUID paymentId, double refundAmount) {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if(paymentOpt.isPresent()){
            Payment payment = paymentOpt.get();
            if ("REFUNDED".equalsIgnoreCase(payment.getStatus())) {
                return Optional.of(payment);
            }
            payment.setStatus("REFUNDED");
            payment.setAmount(refundAmount); // 如需部分退款，可调整逻辑
            Payment refunded = paymentRepository.save(payment);
            paymentKafkaProducer.sendPaymentMessage("Payment Refunded: " + refunded.getId());
            return Optional.of(refunded);
        }
        return Optional.empty();
    }

    // 查询支付记录
    public Optional<Payment> getPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
