package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
//    Enroll a student in a course
//    View enrollments for a student
//    Mark enrollment as completed/cancelled

    private List<Enrollment> enrollmentList = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId, String enrollmentDate) {
        int id = IdGenerator.getNextEnrollmentId();

        Enrollment e = new Enrollment(id, studentId, courseId, enrollmentDate, EnrollmentStatus.ACTIVE);
        enrollmentList.add(e);

        System.out.println("Enrollment successful. ID: " + id);
    }

    public void viewEnrollmentsByStudent(int studentId) {
        boolean found = false;

        for (Enrollment e : enrollmentList) {
            if (e.getStudentId() == studentId) {
                System.out.println("Enrollment ID: " + e.getId() + ", Course ID: " + e.getCourseId() + ", Status: " + e.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for student " + studentId);
        }
    }

    public void markCompleted(int enrollmentId) throws EntityNotFoundException {
        Enrollment e = findById(enrollmentId);
        e.setStatus(EnrollmentStatus.COMPLETED);
        System.out.println("Enrollment marked as COMPLETED");
    }

    public void markCancelled(int enrollmentId) throws EntityNotFoundException {
        Enrollment e = findById(enrollmentId);
        e.setStatus(EnrollmentStatus.CANCELLED);
        System.out.println("Enrollment marked as CANCELLED");
    }


    private Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollmentList) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with id: " + id);
    }


}
