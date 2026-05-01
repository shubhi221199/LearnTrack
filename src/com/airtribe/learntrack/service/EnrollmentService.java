package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
//    Enroll a student in a course
//    View enrollments for a student
//    Mark enrollment as completed/cancelled

     List<Enrollment> enrollmentList = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId, String enrollmentDate) {
        int id = IdGenerator.getNextEnrollmentId();

        Enrollment e = new Enrollment(id, studentId, courseId, enrollmentDate, EnrollmentStatus.ACTIVE);
        enrollmentList.add(e);

        System.out.println("Enrollment successful. ID: " + id);
    }

    public void viewEnrollmentsByStudent(int studentId) {

        for (Enrollment e : enrollmentList) {
            if (e.getStudentId() == studentId) {
                System.out.println("Enrollment ID: " + e.getId() + ", Course ID: " + e.getCourseId() + ", Status: " + e.getStatus());
                return;
            }
        }

        System.out.println("No enrollments found for student " + studentId);

    }

    public void markCompleted(int enrollmentId) throws EntityNotFoundException {
        Enrollment e = findById(enrollmentId);

        if( e.getStatus()==EnrollmentStatus.COMPLETED){
            System.out.println("Enrollment already completed");
            return;
        }
        e.setStatus(EnrollmentStatus.COMPLETED);
        System.out.println("Enrollment marked as completed");
    }

    public void markCancelled(int enrollmentId) throws EntityNotFoundException {
        Enrollment e = findById(enrollmentId);
        if(e.getStatus()==EnrollmentStatus.CANCELLED){
            System.out.println("Enrollment already cancelled");
            return;
        }
        e.setStatus(EnrollmentStatus.CANCELLED);
        System.out.println("Enrollment marked as cancelled");
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
