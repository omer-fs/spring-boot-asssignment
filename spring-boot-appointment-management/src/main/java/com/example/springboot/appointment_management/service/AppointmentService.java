package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.entity.Appointment;

public interface AppointmentService {
    public Appointment findAppointmentById(int theId);

    public void saveAppointment(Appointment theAppointment);

    public void deleteAppointmentById(int theId);
}
