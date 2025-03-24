package com.example.frontend.service;

import com.example.frontend.model.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FrontendService {
    public String checkHealth() {
        return "Frontend Service is running";
    }

    public List<Order> getOrdersForUser(String userId) {
        // Mock response (In real app, call the Orders microservice)
        return Arrays.asList(
                new Order("1", Arrays.asList("Item A", "Item B"), 100.0),
                new Order("2", Arrays.asList("Item C", "Item D"), 150.0)
        );
    }
}
