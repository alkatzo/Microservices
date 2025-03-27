package com.example.frontend.controller;

import com.example.frontend.model.Order;
import com.example.frontend.service.FrontendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FrontendController {
    private final FrontendService frontendService;

    public FrontendController(FrontendService frontendService) {
        this.frontendService = frontendService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return frontendService.checkHealth();
    }

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam String userId) {
        return frontendService.getOrdersForUser(userId);
    }
}
