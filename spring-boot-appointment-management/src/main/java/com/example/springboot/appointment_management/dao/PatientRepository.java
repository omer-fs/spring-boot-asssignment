package com.example.springboot.appointment_management.dao;

import com.example.springboot.appointment_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "patients")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Optional<Patient> findByEmail(String username);
}
