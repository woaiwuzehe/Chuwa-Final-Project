package com.example.order_service.controller;

import com.example.order_service.entities.Order;
import com.example.order_service.payload.CancelOrderRequest;
import com.example.order_service.payload.CreateOrderRequest;
import com.example.order_service.payload.UpdateOrderRequest;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        UUID customerId = UUID.fromString(request.getCustomerId());
        Order order = orderService.createOrder(customerId, request.getTotalAmount());
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable String orderId,
            @RequestBody UpdateOrderRequest request) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> updatedOrder = orderService.updateOrder(uuid, request.getStatus(), request.getTotalAmount());
        return updatedOrder.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> cancelOrder(@PathVariable String orderId,
                                             @RequestBody(required = false) CancelOrderRequest request) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> cancelledOrder = orderService.cancelOrder(uuid);
        return cancelledOrder.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> orderOpt = orderService.getOrderById(uuid);
        return orderOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable String customerId) {
        UUID uuid = UUID.fromString(customerId);
        List<Order> orders = orderService.findOrdersByCustomer(uuid);
        return ResponseEntity.ok(orders);
    }
}

