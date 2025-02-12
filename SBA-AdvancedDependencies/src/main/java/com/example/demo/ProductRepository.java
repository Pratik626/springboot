package com.example.demo; // This is the package where the class belongs

import org.springframework.data.jpa.repository.JpaRepository; // Provides built-in database operations for JPA entities
import java.util.List; // Used to return a list of products when searching by name

// This interface is used to interact with the database for "Product" objects
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This method allows us to find products by their name
    // Example: If the database has multiple products named "Laptop", it returns a list of all laptops
    List<Product> findByName(String name);
}
