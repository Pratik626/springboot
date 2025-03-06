package com.wipro.springboot.usecase1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // JPA will automatically provide CRUD operations
}
