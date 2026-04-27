import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        System.out.printf("Hello and welcome!");

        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        Scanner sc = new Scanner(System.in);
        try {
            int option = Integer.parseInt(sc.nextLine());
//            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("1. Add new student");
                System.out.println("2. View all students");
                System.out.println("3. Search student by ID");
                System.out.println("4. Deactivate a student");
                int choice = sc.nextInt();
                sc.nextLine();

                StudentService studentService = new StudentService();
                switch (choice) {
                    case 1:
                        System.out.print("Enter first name: ");
                        String firstName = sc.nextLine();

                        System.out.print("Enter last name: ");
                        String lastName = sc.nextLine();

                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter batch: ");
                        String batch = sc.nextLine();

                        studentService.addStudent(firstName, lastName, email, batch);
                        System.out.println("Student added!");
                        break;

                    case 2:
                        studentService.listStudents();
                        break;
                    case 3:
                        System.out.print("Enter Student Id: ");
                        int studentId = sc.nextInt();

                        try {
                            Student s = studentService.findStudentById(studentId);
                            System.out.println("Student Found:");
                            System.out.println(s.getId() + " | " + s.getFirstName() + " " + s.getLastName() + " | " + s.getEmail() + " | " + s.getBatch());

                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 4:
                        System.out.print("Enter Student Id: ");
                        int sID = sc.nextInt();
                        try {
                            Student s = studentService.findStudentById(sID);
                            if (s.isActive()) {
                                studentService.statusChange(sID);
                            }
                            {
                                System.out.println("Student Already Deactivated");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } else if (option == 2) {

                System.out.println("1. Add new course");
                System.out.println("2. View all courses");
                System.out.println("3. Activate/Deactivate a course");
                int choice = sc.nextInt();
                CourseService courseService = new CourseService();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Course Name: ");
                        String courseName = sc.nextLine();

                        System.out.println("Enter Description: ");
                        String description = sc.nextLine();

                        System.out.println("Enter Duration In Weeks: ");
                        int durationInWeeks = sc.nextInt();

                        courseService.addCourse(courseName, description, durationInWeeks);
                        System.out.println("Course successfully Added!");
                        break;

                    case 2:
                        courseService.listCourses();
                        break;

                    case 3:
                        System.out.println("Enter Course Id ");
                        try {
                            int courseId = sc.nextInt();
                            Course c = courseService.findCourseById(courseId);
                            if (c.isActive()) {
                                courseService.statusChange(courseId);

                            }
                            {
                                System.out.println("Course Already Deactivated");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } else {
                System.out.println("1. Enroll a student in a course");
                System.out.println("2. View enrollments for a student");
                System.out.println("3. Mark enrollment as completed/cancelled");

                int choice = sc.nextInt();
                EnrollmentService enrollmentService = new EnrollmentService();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        int studentId = sc.nextInt();

                        System.out.print("Enter Course ID: ");
                        int courseId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Enrollment Date: ");
                        String date = sc.nextLine();

                        enrollmentService.enrollStudent(studentId, courseId, date);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        int sId = sc.nextInt();

                        enrollmentService.viewEnrollmentsByStudent(sId);
                        break;
                    case 3:
                        System.out.print("Enter Enrollment ID: ");
                        int eId = sc.nextInt();

                        System.out.println("1. Mark Completed");
                        System.out.println("2. Mark Cancelled");

                        int statusChoice = sc.nextInt();

                        try {
                            if (statusChoice == 1) {
                                enrollmentService.markCompleted(eId);
                            } else if (statusChoice == 2) {
                                enrollmentService.markCancelled(eId);
                            } else {
                                System.out.println("Invalid option!");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter a number.");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

    }
}