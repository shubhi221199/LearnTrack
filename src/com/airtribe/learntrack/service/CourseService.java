package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private CourseRepository repository = new CourseRepository();

    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course c = new Course(id, courseName, description, durationInWeeks, true);
        repository.save(c);
    }

    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course c : repository.getAll()) {
            if (c.getCourseId() == id) {
                return c;

            }
        }
        throw new EntityNotFoundException("Course not found " + id);
    }

    public void listCourses() {
        if (repository.getAll().isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        for (Course c : repository.getAll()) {
            System.out.println(c.getCourseId() + " | " + c.getCourseName() + " " + c.getDescription() + " | " + c.getDurationInWeeks() + " | " + c.isActive());
        }
    }

    public void statusChange(int id) {

        for (Course c : repository.getAll()) {
            if (c.getCourseId() == id) {
                c.setActive(!c.isActive());

            }
        }
    }
}
