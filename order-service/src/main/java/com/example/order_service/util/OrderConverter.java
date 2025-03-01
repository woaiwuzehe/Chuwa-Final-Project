package com.example.order_service.util;

import com.example.order_service.dto.OrderDTO;
import com.example.order_service.entities.Order;

public class OrderConverter {

    public static OrderDTO toDTO(Order order) {
        if (order == null) return null;
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerId(order.getCustomerId());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }
}
