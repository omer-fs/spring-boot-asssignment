package com.example.springboot.appointment_management.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PatientDto {


    private int id;

    @Size(min = 2, message = "First name should be at least 2 characters")
    private String firstName;

    @Size(min = 2,message = "Last Name should be at least 2 characters")
    private String lastName;

    @NotEmpty(message = "Email should not be null")
    private String email;

    @Range(min = 1, max = 100, message = "Age should be between [1-100]")
    private String age;

    @Size(min = 10, message = "Phone Number should be 10 characters")
    private String phoneNumber;


    public PatientDto() {
    }

    public PatientDto(int id, String firstName, String lastName, String email, String age, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
