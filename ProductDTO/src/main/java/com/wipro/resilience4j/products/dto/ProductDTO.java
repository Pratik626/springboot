package com.wipro.resilience4j.products.dto;

public class ProductDTO {
    private int id;
    private String name;
    private String category;
    private String color;
    private int price;

    // Default constructor (needed for frameworks like Spring)
    public ProductDTO() {}

    // Parameterized constructor
    public ProductDTO(int id, String name, String category, String color, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    // Optional: Override toString() for debugging
    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
