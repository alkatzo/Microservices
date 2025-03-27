package com.example.frontend.service;

import com.example.frontend.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FrontendService {
    private final RestTemplate restTemplate;

    @Value("${order.service.url}")  // Injects the Order Service URL from properties
    private String orderServiceUrl;

    public FrontendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String checkHealth() {
        return "Frontend Service is running";
    }

    public List<Order> getOrdersForUser(String userId) {
        // Call the order-service dynamically
        String url = orderServiceUrl + "orders?userId=" + userId;
        System.out.println("Sending request " + url);
        Order[] orders = restTemplate.getForObject(url, Order[].class);
        return List.of(orders);  // Convert array to List
    }
}
