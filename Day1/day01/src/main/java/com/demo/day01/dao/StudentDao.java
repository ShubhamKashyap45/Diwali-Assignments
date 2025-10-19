package com.demo.day01.dao;

import com.demo.day01.model.Student;

import java.util.List;

public interface StudentDao {
    void serializeStudents(List<Student> students);
    List<Student> deserializeStudents();
}