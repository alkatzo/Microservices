package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private int quantity;
    private double price;

    // Many-to-One relationship with Order
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Foreign key column in the order_items table
    @JsonIgnore  // Prevents infinite recursion of saving order inside order_item
    private Order order;

    // Constructors
    public OrderItem() {}

    public OrderItem(String itemName, int quantity, double price, Order order) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
