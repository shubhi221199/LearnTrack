package com.airtribe.learntrack.entity;


//Student
//Fields: id, firstName, lastName, email, batch, active (boolean)
//Course
//Fields: id, courseName, description, durationInWeeks, active
//        Enrollment
//Fields: id, studentId, courseId, enrollmentDate, status (e.g., "ACTIVE",
//        "COMPLETED", "CANCELLED" as String or simple enum if you want
//                                                                 slightly advanced)


public class Student {
    static int id;
    String firstName;
    String lastName;
    String email;
    String batch;
    boolean active;

    Student(){

    }

}
