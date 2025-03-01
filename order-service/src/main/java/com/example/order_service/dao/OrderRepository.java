package com.example.order_service.dao;

import com.example.order_service.entities.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<Order, UUID> {
    // optional, find by customer Id
    List<Order> findByCustomerId(UUID customerId);
}
