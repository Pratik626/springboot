package com.example.demo;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {
    
    private static final String[] jokes = {
        "Why don't programmers like nature? It has too many bugs!",
        "Why do Java developers wear glasses? Because they don't C#.",
        "Why was the JavaScript developer sad? Because he didn't 'null' his feelings."
    };

    private final AtomicLong counter = new AtomicLong(); // Handles unique ID generation

    @GetMapping("/joke")
    public Joke getRandomJoke() {
        Random random = new Random();
        String randomJoke = jokes[random.nextInt(jokes.length)]; // Selects a random joke
        return new Joke(counter.incrementAndGet(), randomJoke); // Returns a Joke record object
    }
}
