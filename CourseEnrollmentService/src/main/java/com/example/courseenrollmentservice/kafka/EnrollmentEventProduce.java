package com.example.courseenrollmentservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentEventProduce {

    private static final String TOPIC = "course-enrollment-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishEvent(String userId, String courseId) {
        String message = "User " + userId + " enrolled in course " + courseId;
        kafkaTemplate.send(TOPIC, message);
    }
}
