package com.wipro.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient  // Enable Eureka Client
public class StudentApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiGatewayApplication.class, args);
    }

    // Define Custom Routes (if required)
    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("student-service", r -> r.path("/students/**")
                .uri("http://localhost:8080"))
            .build();
    }
}
