package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void save(Course c) {
        courses.add(c);
    }

    public void delete(Course c) {
        courses.remove(c);
    }

    public List<Course> getAll() {
        return courses;
    }
}
