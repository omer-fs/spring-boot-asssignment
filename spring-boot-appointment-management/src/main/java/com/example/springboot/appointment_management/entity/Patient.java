package com.example.springboot.appointment_management.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @Size(min = 2,message = "First Name should be at least 2 characters")
    private String firstName;

    @Size(min = 2,message = "Last Name should be at least 2 characters")
    @Column(name="last_name")
    private String lastName;

    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email")
    @Column(name="email", unique = true)
    private String email;

    @Range(min = 1, max = 100, message = "Age should be between [1-100]")
    @Column(name="age")
    private String age;

    @Size(min = 10,message = "Phone Number should be 10 characters")
    @Column(name="phone_number")
    private String phoneNumber;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "patient_id")
    private List<Appointment> appointments;

    public Patient() {

    }

    public Patient(int id, String firstName, String lastName, String email, String age, String phoneNumber) {
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public List<Appointment> getAppointment() {
        return appointments;
    }

    public void setAppointment(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    // add convenience method
    public void addAppointment(Appointment theAppointment) {

        if (appointments == null) {
            appointments = new ArrayList<>();
        }

        appointments.add(theAppointment);

    }

}