package com.airtribe.learntrack.entity;


public class Student extends Person {
    //    static int id;
//    private String firstName;
//    private String lastName;
//    private String email;
    private String batch;
    private boolean active;


    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }

    //GETTER
    public String getBatch() {
        return batch;
    }

    public boolean isActive() {
        return active;
    }

    //    SETTER
    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
