package com.airtribe.learntrack.constants;

public class MenuOptions {

    public static final String STUDENT_MANAGEMENT = "1. Student Management";
    public static final String COURSE_MANAGEMENT = "2. Course Management";
    public static final String ENROLLMENT_MANAGEMENT = "3. Enrollment Management";
    public static final String EXIT_PROGRAM = "4. Exit";

    public static class StudentMenu {
        public static final String ADD = "1. Add new student";
        public static final String VIEW = "2. View all students";
        public static final String SEARCH = "3. Search student by ID";
        public static final String DEACTIVATE = "4. Deactivate a student";
    }


    public static class CourseMenu {
        public static final String ADD = "1. Add new course";
        public static final String VIEW = "2. View all courses";
        public static final String TOGGLE = "3. Activate/Deactivate a course";
    }


    public static class EnrollmentMenu {
        public static final String ENROLL = "1. Enroll a student";
        public static final String VIEW = "2. View enrollments";
        public static final String UPDATE = "3. Mark completed/cancelled";
    }
    
    private MenuOptions() {}
}