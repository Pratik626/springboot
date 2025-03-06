package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produce")
public class ProducerController {
    private final KafkaProducerService producerService;

    public ProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        producerService.sendMessage(topic, message);
        return "Message sent to topic: " + topic;
    }
}