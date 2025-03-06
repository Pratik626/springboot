package com.wipro.springboot.usecase1;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 

import java.util.List; 

// Marks this class as a REST controller, meaning it will handle HTTP requests
@RestController
@RequestMapping("/flights") 
public class FlightController {

    // Injects an instance of FlightService into this controller to handle business logic
    @Autowired
    private FlightService flightService;

    //  for creating a new flight record
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        // Calls the service layer to create a new flight and returns it in the response
        return ResponseEntity.ok(flightService.createFlight(flight));
    }

    // to fetch all available flight records
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        // Retrieves all flights from the service and returns them in the response
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    //  to update an existing flight record by its ID
    @PutMapping("/update/{id}") // Handles HTTP PUT requests at /flights/update/{id}
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        // Calls the service layer to update the flight with the given ID
        Flight updatedFlight = flightService.updateFlight(id, flightDetails);

        // If the flight is found and updated, return the updated flight
        if (updatedFlight != null) {
            return ResponseEntity.ok(updatedFlight);
        } else {
            // If no flight is found with the given ID, return HTTP 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }
}
