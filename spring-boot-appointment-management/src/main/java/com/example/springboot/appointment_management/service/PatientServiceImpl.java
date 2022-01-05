package com.example.springboot.appointment_management.service;

import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository thePatientRepository) {
        patientRepository = thePatientRepository;
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);

        Patient thePatient = null;

        if(result.isPresent()) {
            thePatient = result.get();
        }
        else {
            // could not find the patient
            throw new MyException("Could not find the Patient Id - " + theId);
        }

        return thePatient;
    }

    @Override
    public Patient findPatientByEmail(String theUsername) {
        Optional<Patient> result = patientRepository.findByEmail(theUsername);

        Patient thePatient = null;

        if(result.isPresent()) {
            thePatient = result.get();
        }
        else {
            // could not find the patient
            throw new MyException("Could not find the Patient - " + theUsername);
        }

        return thePatient;
    }

    @Override
    public void savePatient(Patient thePatient) {
        patientRepository.save(thePatient);
    }

    @Override
    public void deletePatientById(int theId) {
        patientRepository.deleteById(theId);
    }
}
