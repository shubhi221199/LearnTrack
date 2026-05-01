# LearnTrack – Student & Course Management System

## 📌 Project Description

LearnTrack is a console-based Java application designed to manage students, courses, and enrollments in an organised and structured way.

This project focuses on demonstrating **core Java fundamentals** along with **clean coding practices** and **modular architecture**. It simulates a real-world backend system where different entities interact through a service layer.

The application is fully menu-driven and operates using in-memory data structures, making it ideal for learning, practice, and interview preparation.

---

## 🚀 Features

* Add, view, update, and deactivate students
* Add and manage courses
* Enroll students into courses
* View enrollments by student
* Mark enrollments as **COMPLETED** or **CANCELLED**
* Input validation to prevent crashes
* Graceful error handling using custom exceptions

---

## ⚙️ How to Compile and Run

### 🪟 Windows (PowerShell / CMD)

```bash
cd src
javac -d ../out com/airtribe/learntrack/Main.java
cd ..
java -cp out com.airtribe.learntrack.Main
```

---

### 🍎 macOS / 🐧 Linux (bash / zsh)

```bash
cd src
javac -d ../out com/airtribe/learntrack/Main.java
cd ..
java -cp out com.airtribe.learntrack.Main
```

---

### 🧠 Why this works

* Compiling `Main.java` automatically compiles all dependent classes
* `-d ../out` stores compiled `.class` files inside the `out` directory
* `-cp out` sets the correct classpath for execution
* Ensures proper package-based compilation

---

## 🧱 Project Structure

```text
com.airtribe.learntrack
│
├── entity        # Data models (Student, Course, Enrollment, Person)
├── service       # Business logic layer
├── Main          # Console-based UI (menu-driven)
├── util          # Utility classes (IdGenerator, InputValidator)
├── exception     # Custom exceptions
├── constants     # Menu and application constants
├── enums         # Enum classes (e.g., EnrollmentStatus)
└── docs          # Documentation files
```

---

## 🧠 Class Diagram

```text
                +------------------+
                |     Person       |
                |------------------|
                | id               |
                | firstName        |
                | lastName         |
                | email            |
                |------------------|
                | getDisplayName() |
                +--------▲---------+
                         |
        +----------------+----------------+
        |                                 |
+------------------+              +------------------+
|     Student      |              |     Trainer      |
|------------------|              |------------------|
| batch            |              | expertise        |
+------------------+              +------------------+


+------------------+        +------------------+
|      Course      |        |    Enrollment    |
|------------------|        |------------------|
| id               |        | id               |
| courseName       |        | studentId        |
| description      |        | courseId         |
| durationInWeeks  |        | enrollmentDate   |
| active           |        | status           |
+------------------+        +------------------+


+-----------------------+
|    StudentService     |
+-----------------------+
| addStudent()          |
| removeStudent()       |
| updateStudent()       |
| listStudents()        |
+-----------------------+

+-----------------------+
|    CourseService      |
+-----------------------+
| addCourse()           |
| listCourses()         |
| statusChange()        |
+-----------------------+

+----------------------------+
|   EnrollmentService        |
+----------------------------+
| enrollStudent()            |
| viewEnrollmentsByStudent() |
| markCompleted()            |
| markCancelled()            |
+----------------------------+
```

---

## 🧠 Key Concepts Used

* **Encapsulation** → private fields with controlled access via getters/setters
* **Inheritance** → `Student` and `Trainer` extend `Person`
* **Polymorphism** → method overriding for customised behaviour
* **Collections** → `ArrayList` used for dynamic data storage
* **Exception Handling** → custom exceptions with clean user messages
* **Static Usage** → centralised ID generation using static counters

---

## 📝 Notes

* Data is stored **in-memory** (no database used intentionally)
* Designed to emphasize **fundamentals over frameworks**
* Follows **layered architecture** for better readability and scalability
* Built as a **learning + interview-ready project**

---

## ✅ Conclusion

LearnTrack demonstrates how to build a well-structured Java application using core OOP principles, clean architecture, and proper separation of concerns. It serves as a strong foundation for backend development and real-world application design.
