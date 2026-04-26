package com.airtribe.learntrack.entity;

//Fields: id, firstName, lastName, email

public class Person {
    public int id;
    private String firstName;
    private String lastName;
    private String email;

    Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void getDisplayName() {
        System.out.println("Student name is :" + firstName + " " + lastName);
    }

}
