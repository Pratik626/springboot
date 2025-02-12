package com.example.demo; // This is the package where the class belongs

import org.springframework.boot.CommandLineRunner; // Allows code to run when the application starts
import org.springframework.stereotype.Component; // Marks this class as a Spring-managed component

// This class runs when the application starts and adds sample products to the database
@Component
public class ProductCommandLineRunner implements CommandLineRunner {

    // This is a reference to the ProductRepository to interact with the database
    private final ProductRepository repository;

    // Constructor that initializes the repository
    public ProductCommandLineRunner(ProductRepository repository) {
        this.repository = repository;
    }

    // This method runs automatically when the application starts
    @Override
    public void run(String... args) {
        
        // Save sample products to the database
        repository.save(new Product("Laptop", 75000.00));
        repository.save(new Product("Smartphone", 25000.00));
        repository.save(new Product("Headphones", 3000.00));
        repository.save(new Product("Keyboard", 1500.00));
        repository.save(new Product("Monitor", 12000.00));

        // Print all products from the database
        System.out.println("\n== Products found with findAll():");
        System.out.println(); // Print an empty line for better readability
        repository.findAll().forEach(System.out::println); // Fetch and print all products

        // Find a product by ID (Here, it tries to find the product with ID 1)
        System.out.println("\n== Product found with findById(1L):");
        System.out.println();
        repository.findById(1L).ifPresent(System.out::println); // Print the product if found

        // Find products by name (Example: Find all products named "Laptop")
        System.out.println("\n== Products found with findByName('Laptop'):");
        System.out.println();
        repository.findByName("Laptop").forEach(System.out::println); // Fetch and print products with name "Laptop"
    }
}
