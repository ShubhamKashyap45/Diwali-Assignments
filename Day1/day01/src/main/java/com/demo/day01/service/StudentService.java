package com.demo.day01.service;

import com.demo.day01.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> createAndProcessStudents();
    List<Student> deserializeStudents();
}