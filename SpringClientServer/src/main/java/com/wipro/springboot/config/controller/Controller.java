package com.wipro.springboot.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Value("${my.custom.property:Hello from Client Side}")
    private String customProperty;

    @GetMapping("/config")
    public String getConfigProperty() {
        return "Response: " + customProperty;
    }
}
