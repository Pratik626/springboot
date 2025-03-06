package com.wipro.resilience4j.car.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    private String model;
    private String brand;
    private String color;
    private int price;
    private String category;

    // Constructors
    public Car() {}

    public Car(String model, String brand, String color, int price, String category) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
