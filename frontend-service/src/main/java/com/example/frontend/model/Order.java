package com.example.frontend.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order {
    private String id;
    private List<String> items;
    private double totalAmount;

    // Constructors
    public Order() {}

    public Order(String id, List<String> items, double totalAmount) {
        this.id = id;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
