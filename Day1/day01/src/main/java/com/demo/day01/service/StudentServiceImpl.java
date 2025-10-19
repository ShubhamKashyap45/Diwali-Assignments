package com.demo.day01.service;

import com.demo.day01.dao.StudentDao;
import com.demo.day01.exception.LowAttendanceException;
import com.demo.day01.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> createAndProcessStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Rahul", "Java", 85, 90));
        students.add(new Student(2, "Priya", "Python", 55, 80));
        students.add(new Student(3, "Amit", "C++", 75, 88));
        students.add(new Student(4, "Sneha", "Java", 92, 95));
        students.add(new Student(5, "Vikas", "C#", 60, 70));
        students.add(new Student(6, "Meena", "JavaScript", 59, 65));
        students.add(new Student(7, "Karan", "Python", 82, 76));
        students.add(new Student(8, "Ravi", "Java", 70, 68));
        students.add(new Student(9, "Anjali", "C++", 64, 72));
        students.add(new Student(10, "Deepak", "Java", 91, 89));

        for (Student s : students) {
            try {
                s.calculateGrade();
            } catch (LowAttendanceException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        students.sort(Comparator.comparingDouble(Student::getAttendancePercentage).reversed());

        studentDao.serializeStudents(students);
        return students;
    }

    @Override
    public List<Student> deserializeStudents() {
        return studentDao.deserializeStudents();
    }
}