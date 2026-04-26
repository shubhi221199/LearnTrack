package com.airtribe.learntrack.entity;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, int studentId, int courseId, String enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    //GETTER
    public int getId(int id){
        return id;
    }
    public int getStudentId(int studentId){
        return studentId;
    }
    public int getCourseId(int courseId){
        return courseId;
    }
    public String getEnrollmentDate(String enrollmentDate){
        return enrollmentDate;
    }
    public EnrollmentStatus getStatus(EnrollmentStatus status) {
        return status;
    }

//    SETTER


    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}