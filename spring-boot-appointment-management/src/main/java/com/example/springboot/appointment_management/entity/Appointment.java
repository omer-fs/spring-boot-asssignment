package com.example.springboot.appointment_management.entity;


import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="appointment")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Size(min = 2, message = "Doctor name should be at least 2 characters")
    @Column(name="doctor_name")
    private String doctorName;

    @Size(min =6, message = "Date cannot be null")
    @Column(name="appointment_date")
    private String appointmentDate;

    @Size(min=6, message = "Time cannot be null")
    @Column(name="appointment_time")
    private String appointmentTime;

    @Size(min=2, message = "Reason should be at least 2 characters")
    @Column(name="reason")
    private String reason;


    public Appointment(int id, String doctorName, String appointmentDate, String appointmentTime, String reason) {
        this.id = id;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    public Appointment(String doctorName, String appointmentDate, String appointmentTime, String reason) {
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }
}
