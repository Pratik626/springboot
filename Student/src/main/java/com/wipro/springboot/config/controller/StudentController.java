package com.wipro.springboot.config.controller;

import org.springframework.web.bind.annotation.*;
import com.wipro.springboot.config.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    // GET - Retrieve all students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // POST - Add a new student
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    // PUT - Update an existing student
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }

    // DELETE - Remove a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
        return "Student deleted successfully!";
    }
}
