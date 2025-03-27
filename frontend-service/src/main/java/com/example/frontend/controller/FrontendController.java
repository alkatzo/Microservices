package com.example.frontend.controller;

import com.example.frontend.model.Order;
import com.example.frontend.service.FrontendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // disable CORS for VITA frontend access. Should be done via WebConfig
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
