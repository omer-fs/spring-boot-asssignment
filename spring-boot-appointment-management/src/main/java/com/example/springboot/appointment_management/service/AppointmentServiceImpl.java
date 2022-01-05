package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.dao.AppointmentRepository;
import com.example.springboot.appointment_management.entity.Appointment;
import com.example.springboot.appointment_management.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository theAppointmentRepository) {
        appointmentRepository = theAppointmentRepository;
    }

    @Override
    public Appointment findAppointmentById(int theId) {
        Optional<Appointment> result = appointmentRepository.findById(theId);

        Appointment theAppointment = null;

        if (result.isPresent()) {
            theAppointment = result.get();
        }
        else {
            // we didn't find the appointment for patient
            throw new MyException("Could not find the Appointment id - "+ theId);
        }

        return theAppointment;
    }

    @Override
    public void saveAppointment(Appointment theAppointment) {
        appointmentRepository.save(theAppointment);
    }

    @Override
    public void deleteAppointmentById(int theId) {
        appointmentRepository.deleteById(theId);
    }
}
