package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment e) {
        enrollments.add(e);

    }

    public List<Enrollment> getAll() {
        return enrollments;
    }
}
