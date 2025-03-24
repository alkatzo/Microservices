package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersForUser(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
