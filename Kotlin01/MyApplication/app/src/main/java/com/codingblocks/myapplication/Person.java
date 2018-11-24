package com.codingblocks.myapplication;

public class Person {
    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFullName(String fullName) {
        String[] splitName = fullName.split(" ");
        this.firstName = splitName[0];
        if (splitName.length > 1) {
            this.lastName = splitName[1];
        } else {
            this.lastName = "";
        }

    }
}
