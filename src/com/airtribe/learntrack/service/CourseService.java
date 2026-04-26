package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(String courseName, String description, int durationInWeeks, boolean active) {
        int id = IdGenerator.getNextCourseId();
        Course c = new Course(id, courseName, description, durationInWeeks, active);
        courses.add(c);
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        for (Course c : courses) {
            System.out.println(c.getCourseId() + " | " + c.getCourseName() + " " + c.getDescription() + " | " + c.getDurationInWeeks()+" | " + c.isActive());
        }
    }

    public void statusChange (int id){

        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setActive(!c.isActive());

            }
        }
    }
}
