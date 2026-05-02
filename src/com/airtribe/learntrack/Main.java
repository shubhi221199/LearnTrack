package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean isExit = false;

        while (!isExit) {

            System.out.println("\n=== Main Menu ===");
            System.out.println(MenuOptions.STUDENT_MANAGEMENT);
            System.out.println(MenuOptions.COURSE_MANAGEMENT);
            System.out.println(MenuOptions.ENROLLMENT_MANAGEMENT);
            System.out.println(MenuOptions.EXIT_PROGRAM);

            int option = InputValidator.readInt(sc, "Enter option: ");

            switch (option) {
                case 1:
                    handleStudentMenu(sc, studentService);
                    break;
                case 2:
                    handleCourseMenu(sc, courseService);
                    break;
                case 3:
                    handleEnrollmentMenu(sc, enrollmentService);
                    break;
                case 4:
                    isExit = true;
                    break;
                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }
        }

        sc.close();
    }

    //  STUDENT MENU
    private static void handleStudentMenu(Scanner sc, StudentService service) {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- Student Menu ---");
            System.out.println(MenuOptions.StudentMenu.ADD);
            System.out.println(MenuOptions.StudentMenu.VIEW);
            System.out.println(MenuOptions.StudentMenu.SEARCH);
            System.out.println(MenuOptions.StudentMenu.DEACTIVATE);
            System.out.println("5. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            switch (choice) {

                case 1:
                    String firstName = InputValidator.readNonEmptyString(sc, "Enter first name: ");
                    String lastName = InputValidator.readNonEmptyString(sc, "Enter last name: ");
                    String email = InputValidator.readEmail(sc, "Enter email: ");
                    String batch = InputValidator.readNonEmptyString(sc, "Enter batch: ");

                    if (email.isEmpty()) {
                        service.addStudent(firstName, lastName);
                    } else {

                        service.addStudent(firstName, lastName, email, batch);
                    }
                    System.out.println(AppConstants.SUCCESS);
                    break;

                case 2:
                    service.listStudents();
                    break;

                case 3:
                    int studentId = InputValidator.readInt(sc, "Enter Student Id: ");

                    if (studentId < AppConstants.MIN_ID) {
                        System.out.println(AppConstants.INVALID_INPUT);
                        break;
                    }

                    try {
                        Student s = service.findStudentById(studentId);
                        System.out.println(s.getId() + " | " + s.getFirstName() + " " + s.getLastName() + " | " + s.getEmail() + " | " + s.getBatch());
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    int sId = InputValidator.readInt(sc, "Enter Student Id: ");

                    try {
                        Student s = service.findStudentById(sId);

                        if (s.isActive()) {
                            service.statusChange(sId);
                            System.out.println(AppConstants.SUCCESS);
                        } else {
                            System.out.println("Student already deactivated");
                        }

                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }
        }
    }

    //  COURSE MENU
    private static void handleCourseMenu(Scanner sc, CourseService service) {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- Course Menu ---");
            System.out.println(MenuOptions.CourseMenu.ADD);
            System.out.println(MenuOptions.CourseMenu.VIEW);
            System.out.println(MenuOptions.CourseMenu.TOGGLE);
            System.out.println("4. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            switch (choice) {

                case 1:
                    String courseName = InputValidator.readNonEmptyString(sc, "Enter Course Name: ");
                    String description = InputValidator.readNonEmptyString(sc, "Enter Description: ");
                    int duration = InputValidator.readInt(sc, "Enter Duration (weeks): ");

                    service.addCourse(courseName, description, duration);
                    System.out.println(AppConstants.SUCCESS);
                    break;

                case 2:
                    service.listCourses();
                    break;

                case 3:
                    int courseId = InputValidator.readInt(sc, "Enter Course Id: ");

                    try {
                        service.statusChange(courseId);
                        System.out.println(AppConstants.SUCCESS);
                    } catch (Exception e) {
                        System.out.println(AppConstants.ENTITY_NOT_FOUND);
                    }
                    break;

                case 4:
                    back = true;
                    break;

                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }
        }
    }

    //  ENROLLMENT MENU
    private static void handleEnrollmentMenu(Scanner sc, EnrollmentService service) {

        boolean back = false;

        while (!back) {

            System.out.println("\n--- Enrollment Menu ---");
            System.out.println(MenuOptions.EnrollmentMenu.ENROLL);
            System.out.println(MenuOptions.EnrollmentMenu.VIEW);
            System.out.println(MenuOptions.EnrollmentMenu.UPDATE);
            System.out.println("4. Back");

            int choice = InputValidator.readInt(sc, "Enter choice: ");

            switch (choice) {

                case 1:
                    int studentId = InputValidator.readInt(sc, "Enter Student ID: ");
                    int courseId = InputValidator.readInt(sc, "Enter Course ID: ");
                    String date = InputValidator.readNonEmptyString(sc, "Enter Enrollment Date: ");

                    service.enrollStudent(studentId, courseId, date);
                    System.out.println(AppConstants.SUCCESS);
                    break;

                case 2:
                    int sId = InputValidator.readInt(sc, "Enter Student ID: ");
                    service.viewEnrollmentsByStudent(sId);
                    break;

                case 3:
                    int eId = InputValidator.readInt(sc, "Enter Enrollment ID: ");

                    System.out.println("1. Mark Completed");
                    System.out.println("2. Mark Cancelled");

                    int statusChoice = InputValidator.readInt(sc, "Enter choice: ");

                    try {
                        if (statusChoice == 1) {
                            service.markCompleted(eId);
                        } else if (statusChoice == 2) {
                            service.markCancelled(eId);
                        } else {
                            System.out.println(AppConstants.INVALID_INPUT);
                        }
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    back = true;
                    break;

                default:
                    System.out.println(AppConstants.INVALID_INPUT);
            }
        }
    }
}