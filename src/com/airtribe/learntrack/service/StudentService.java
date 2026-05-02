package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student s = new Student(id, firstName, lastName, email, batch, true);
        students.add(s);

    }
//overloading
    public void addStudent(String firstName, String lastName) {
        // default values
        int id = IdGenerator.getNextStudentId();
        String defaultBatch = "General";
        Student s = new Student(id, firstName, lastName, defaultBatch);
        students.add(s);
    }

    public void removeStudent(int id) throws EntityNotFoundException {
        Student s = findStudentById(id);
        students.remove(s);
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch, boolean active) throws EntityNotFoundException {

        Student s = findStudentById(id);
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setEmail(email);
        s.setBatch(batch);
        s.setActive(active);
    }

    public void statusChange(int id) {

        for (Student c : students) {
            if (c.getId() == id) {
                c.setActive(!c.isActive());

            }
        }
    }

    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with id: " + id);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getFirstName() + " " + s.getLastName() + " | " + s.getEmail() + " | " + s.getBatch() + " | " + s.isActive());
        }
    }
}
