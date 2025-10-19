package com.demo.day01.dao;

import com.demo.day01.model.Student;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static final String FILE_NAME = "students.ser";

    @Override
    public void serializeStudents(List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
            System.out.println("\n Students serialized successfully to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> deserializeStudents() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) in.readObject();
            System.out.println("\n Deserialized " + students.size() + " students from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" No serialized data found yet. Please run /students/process first.");
        }
        return students;
    }
}