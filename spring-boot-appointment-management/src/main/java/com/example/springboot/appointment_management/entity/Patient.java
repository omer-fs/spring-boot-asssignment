package com.example.springboot.appointment_management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

//    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email") commented due to security issue with sonar cloud
    @NotEmpty(message = "Email should not be null")
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


    public Patient(int id, String firstName, String lastName, String email, String age, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Patient(String firstName, String lastName, String email, String age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
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