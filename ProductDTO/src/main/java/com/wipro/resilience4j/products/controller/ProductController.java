package com.wipro.resilience4j.products.controller;

import com.wipro.resilience4j.products.dto.ProductDTO;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/product-service")
public class ProductController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:9191/products";
    private static final String PRODUCT_SERVICE = "productService";
    private int attempt = 1;

    @GetMapping("/fetchProducts")
    @Retry(name = PRODUCT_SERVICE, fallbackMethod = "getAvailableProducts")
    public List<ProductDTO> fetchProducts(@RequestParam("category") String category) {
        String url = BASE_URL + "/" + category;
        System.out.println("Retry method called " + attempt++ + " times at " + new Date());
        return restTemplate.getForObject(url, List.class);
    }

    public List<ProductDTO> getAvailableProducts(String category, Exception e) {
        return Stream.of(
                new ProductDTO(101, "Laptop", "Electronics", "Silver", 75000),
                new ProductDTO(102, "Smartphone", "Electronics", "Black", 50000),
                new ProductDTO(103, "Shoes", "Fashion", "White", 2000),
                new ProductDTO(104, "Backpack", "Accessories", "Blue", 1500)
        )
        .filter(product -> product.getCategory().equalsIgnoreCase(category)) // ✅ Filters by category
        .collect(Collectors.toList());
    }
}
