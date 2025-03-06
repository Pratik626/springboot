package com.bookservice.controller;


import org.springframework.web.bind.annotation.*;

import com.bookservice.model.Book;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public List<Book> getBooks() {
        return List.of(
                new Book(1, "Java Programming", "Nikhil"),
                new Book(2, "Spring Boot", "Pratik")
        );
    }
}
