package com.example.orderservice.model;

public class Order {
    private int id;
    private String customerName;
    private String bookTitle;

    public Order(int id, String customerName, String bookTitle) {
        this.id = id;
        this.customerName = customerName;
        this.bookTitle = bookTitle;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

    // Getters and Setters
}
