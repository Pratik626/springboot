package com.wipro.resilience4j.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.resilience4j.car.entity.Car;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);

    // Case-insensitive category search
    List<Car> findByCategoryIgnoreCase(String category);
}
