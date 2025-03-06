package com.wipro.springboot.usecase1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightService { // Service class responsible for handling business logic for Flight operations

    @Autowired
    private FlightRepository flightRepository; // Injects the FlightRepository to interact with the database

    // Create a new flight
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight); // Saves the flight entity in the database and returns the saved object
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll(); // Retrieves all flights from the database and returns them as a list
    }

    // Update flight details
    public Flight updateFlight(Long id, Flight flightDetails) {
        return flightRepository.findById(id) // Searches for a flight by its ID
                .map(flight -> { // If the flight exists, update its details
                    flight.setFlightNumber(flightDetails.getFlightNumber()); // Updates the flight number
                    flight.setDestination(flightDetails.getDestination()); // Updates the destination
                    flight.setDeparture(flightDetails.getDeparture()); // Updates the departure details
                    return flightRepository.save(flight); // Saves the updated flight back to the database
                }).orElse(null); // Returns null if no flight is found with the given ID
    }
}
