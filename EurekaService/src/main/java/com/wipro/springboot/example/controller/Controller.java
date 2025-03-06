package com.wipro.springboot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String helloworld() {
        return "Healthy 1!!";
    }
}