package com.wipro.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wipro.springboot.example.controller")
@SpringBootApplication
public class EurekaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
}