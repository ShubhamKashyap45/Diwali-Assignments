package com.demo.day01.controller;

import com.demo.day01.model.Student;
import com.demo.day01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/process")
    public List<Student> processStudents() {
        return studentService.createAndProcessStudents();
    }

    @GetMapping("/view")
    public List<Student> viewStudents() {
        return studentService.deserializeStudents();
    }
}