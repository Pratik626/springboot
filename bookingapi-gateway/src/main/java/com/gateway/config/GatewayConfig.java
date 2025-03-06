package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("book-service", r -> r.path("/api/books/**")
                        .uri("http://localhost:8081"))
                .route("customer-service", r -> r.path("/api/customers/**")
                        .uri("http://localhost:8082"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}
