package com.demo.day01.model;

import com.demo.day01.exception.LowAttendanceException;

import java.io.Serializable;

public class Student implements Serializable {
    private int rollno;
    private String sname;
    private String course;
    private double attendancePercentage;
    private double score;
    private String grade;

    public Student() {}

    public Student(int rollno, String sname, String course, double attendancePercentage, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendancePercentage = attendancePercentage;
        this.score = score;
    }

    public void calculateGrade() throws LowAttendanceException {
        if (attendancePercentage < 60)
            throw new LowAttendanceException("Attendance below 60% for " + sname + " (Roll No: " + rollno + ")");

        if (score >= 90) grade = "A";
        else if (score >= 75) grade = "B";
        else if (score >= 60) grade = "C";
        else grade = "D";
    }

    public double getAttendancePercentage() { return attendancePercentage; }

    @Override
    public String toString() {
        return String.format("RollNo: %d, Name: %s, Course: %s, Attendance: %.1f%%, Score: %.1f, Grade: %s",
                rollno, sname, course, attendancePercentage, score, grade);
    }
}