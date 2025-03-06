package com.wipro.resilience4j.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.resilience4j.car.entity.Car;
import com.wipro.resilience4j.car.repository.CarRepository;

@SpringBootApplication
@RestController
@RequestMapping("/cars")  
public class CarCatalogApplication {

    private final CarRepository carRepository;

    @Autowired
    public CarCatalogApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarCatalogApplication.class, args);
    }

    
    @EventListener(ApplicationReadyEvent.class)
    public void initCars() {
        carRepository.saveAll(Stream.of(
                new Car("Etios", "Toyota", "White", 25000, "Sedan"),
                new Car("Civic", "Honda", "Black", 22000, "Sedan"),
                new Car("Explorer", "Ford", "Red", 35000, "SUV"),
                new Car("X5", "BMW", "Black", 60000, "SUV"),
                new Car("Q5", "Audi", "Gray", 50000, "SUV"),
                new Car("911", "Porsche", "Yellow", 120000, "Sports"),
                new Car("Mustang", "Ford", "Red", 250000, "Sports")
        ).collect(Collectors.toList()));
    }

    // Get all cars
    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    // Get cars by brand
    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carRepository.findByBrand(brand);
    }

    // Get cars by category (e.g., Sedan, SUV, Sports)
    @GetMapping("/category/{category}")
    public List<Car> getCarsByCategory(@PathVariable String category) {
        return carRepository.findByCategoryIgnoreCase(category);
    }
}
