package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> findAllPatients();

    public Patient findPatientById(int theId);

    public Patient findPatientByEmail(String theUsername);

    public void savePatient(Patient thePatient);

    public void deletePatientById(int theId);
}
