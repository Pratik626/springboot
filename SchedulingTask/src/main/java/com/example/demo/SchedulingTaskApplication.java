package com.example.demo; 

// Imports Spring Boot’s SpringApplication class to launch the application.
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Enables Spring Boot’s auto-configuration feature.
import org.springframework.scheduling.annotation.EnableScheduling;  // Imports the annotation that allows scheduling tasks in Spring Boot.

@SpringBootApplication  // Marks this as a Spring Boot application, enabling auto-configuration and component scanning.
@EnableScheduling  // Enables scheduling, allowing the application to run scheduled tasks at fixed times.
public class SchedulingTaskApplication {  // Defines the main application class.

    public static void main(String[] args) {  // Main method, which serves as the entry point of the application.
        SpringApplication.run(SchedulingTaskApplication.class, args);  // Starts the Spring Boot application.
    }
}
