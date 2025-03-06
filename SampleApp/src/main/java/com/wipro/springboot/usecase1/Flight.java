package com.wipro.springboot.usecase1; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

// Declares this class as a JPA entity (maps to a database table)
@Entity
// Specifies the table name in the database as "flights"
@Table(name = "flights")
public class Flight { // Defines the Flight class

    // Marks this field as the primary key of the table
    @Id
    // Automatically generates a unique value for each record (Identity strategy)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each flight record

    // Defines a column for flightNumber, ensuring it is unique and cannot be null
    @Column(nullable = false, unique = true)
    private String flightNumber; // Stores the flight number (e.g., AI101)

    // Defines a column for destination, ensuring it cannot be null
    @Column(nullable = false)
    private String destination; // Stores the destination of the flight (e.g., New York)

    // Defines a column for departure, ensuring it cannot be null
    @Column(nullable = false)
    private String departure; // Stores the departure location of the flight (e.g., Delhi)

    // Default constructor (needed by JPA for entity instantiation)
    public Flight() {}

    // Parameterized constructor to create a Flight object with specific values
    public Flight(String flightNumber, String destination, String departure) {
        this.flightNumber = flightNumber; // Assigns the flight number
        this.destination = destination; // Assigns the destination
        this.departure = departure; // Assigns the departure location
    }

    // Getter method to retrieve the flight ID
    public Long getId() { return id; }

    // Setter method to set the flight ID
    public void setId(Long id) { this.id = id; }

    // Getter method to retrieve the flight number
    public String getFlightNumber() { return flightNumber; }

    // Setter method to update the flight number
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    // Getter method to retrieve the destination
    public String getDestination() { return destination; }

    // Setter method to update the destination
    public void setDestination(String destination) { this.destination = destination; }

    // Getter method to retrieve the departure location
    public String getDeparture() { return departure; }

    // Setter method to update the departure location
    public void setDeparture(String departure) { this.departure = departure; }
}
