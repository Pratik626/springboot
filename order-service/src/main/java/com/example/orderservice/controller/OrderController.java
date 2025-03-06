package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.*;

import com.example.orderservice.model.Order;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping
    public List<Order> getOrders() {
        return List.of(
                new Order(1, "Nikhil", "Java Programming"),
                new Order(2, "Pratik", "Spring Boot")
        );
    }
}
