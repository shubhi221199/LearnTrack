package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch, boolean active) {
        int id = IdGenerator.getNextStudentId();
        Student s = new Student(id, firstName, lastName, email, batch, active);
        students.add(s);

    }


    public void removeStudent(int id) {
        for (Student std : students) {
            if (std.getId() == id) {
                students.remove(std);
            }
        }
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch, boolean active) {
        for (Student std : students) {
            if (std.getId() == id) {
                std.setFirstName(firstName);
                std.setLastName(lastName);
                std.setEmail(email);
                std.setBatch(batch);
                std.setActive(active);

            }
        }
    }

    public void statusChange (int id){

        for (Student c : students) {
            if (c.getId() == id) {
                c.setActive(!c.isActive());

            }
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getFirstName() + " " + s.getLastName() + " | " + s.getEmail() + " | " + s.getBatch()+ " | " + s.isActive());
        }
    }
}
