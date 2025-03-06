package com.example.customerservice.controller;


import org.springframework.web.bind.annotation.*;

import com.example.customerservice.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1, "Nikhil", "nikhil@example.com"),
                new Customer(2, "Pratik", "pratik@example.com")
        );
    }
}
