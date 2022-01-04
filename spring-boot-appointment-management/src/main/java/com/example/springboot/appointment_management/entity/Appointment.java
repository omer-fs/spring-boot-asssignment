package com.example.springboot.appointment_management.entity;


import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="appointment")
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

    public Appointment() {

    }

    public Appointment(int id, String doctorName, String appointmentDate, String appointmentTime, String reason) {
        this.id = id;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
