package com.example.courseenrollmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseenrollmentservice.kafka.EnrollmentEventProduce;
import com.example.courseenrollmentservice.model.UserEnrollment;
import com.example.courseenrollmentservice.repository.UserEnrollmentRepository;

@RestController
@RequestMapping("/api/enrollments")
public class UserEnrollmentController {

    @Autowired
    private UserEnrollmentRepository repository;

    @Autowired
    private EnrollmentEventProduce eventProducer;

    @PostMapping
    public UserEnrollment enrollUser(@RequestBody UserEnrollment enrollment) {
        eventProducer.publishEvent(enrollment.getUserId(), enrollment.getCourseId());
        return repository.save(enrollment);
    }

    @GetMapping("/user/{userId}")
    public List<UserEnrollment> getCoursesByUser(@PathVariable String userId) {
        return repository.findByUserId(userId);
    }

    @GetMapping("/course/{courseId}")
    public List<UserEnrollment> getUsersByCourse(@PathVariable String courseId) {
        return repository.findByCourseId(courseId);
    }

    @DeleteMapping("/user/{userId}/course/{courseId}")
    public String unenrollUser(@PathVariable String userId, @PathVariable String courseId) {
        repository.deleteByUserIdAndCourseId(userId, courseId);
        return "Unenrolled successfully";
    }
}
