package com.example.courseenrollmentservice.repository;

import com.example.courseenrollmentservice.model.UserEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEnrollmentRepository extends JpaRepository<UserEnrollment, Long> {
    List<UserEnrollment> findByUserId(String userId);
    List<UserEnrollment> findByCourseId(String courseId);
    void deleteByUserIdAndCourseId(String userId, String courseId);
}
