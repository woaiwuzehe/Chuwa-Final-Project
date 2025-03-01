package com.example.payment_service.dao;

import com.example.payment_service.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    // optional，find by order Id
    Payment findByOrderId(UUID orderId);
}
