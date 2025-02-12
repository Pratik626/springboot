package com.example.demo; // This is the package where the class belongs

import jakarta.persistence.Entity; // Marks this class as a database table
import jakarta.persistence.GeneratedValue; // Used for auto-generating the ID
import jakarta.persistence.GenerationType; // Defines how the ID is generated
import jakarta.persistence.Id; // Marks a field as the primary key

// This class represents a "Product" table in the database
@Entity
public class Product {

    // This field is the primary key (unique identifier for each product)
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID in the database
    private Long id; // Unique ID for each product

    private String name; // Name of the product
    private double price; // Price of the product

    // Default constructor (needed for JPA to work properly)
    public Product() {}

    // Constructor to create a new Product with a name and price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // This method is used to print the Product object in a readable format
    @Override
    public String toString() {
        return "Product[id=" + id + ", name='" + name + "', price=" + price + "]";
    }
}
