package com.example.springboot.appointment_management.dto;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class AppointmentDto {

    private int id;

    @Size(min = 2, message = "Doctor name should be at least 2 characters")
    private String doctorName;

    @Size(min =6, message = "Date cannot be null")
    private String appointmentDate;

    @Size(min=6, message = "Time cannot be null")
    private String appointmentTime;

    @Size(min=2, message = "Reason should be at least 2 characters")
    private String reason;

    public AppointmentDto() {
    }

    public AppointmentDto(int id, String doctorName, String appointmentDate, String appointmentTime, String reason) {
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
}
