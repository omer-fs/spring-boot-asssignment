package com.example.springboot.appointment_management.dao;

import com.example.springboot.appointment_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "appointments")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
