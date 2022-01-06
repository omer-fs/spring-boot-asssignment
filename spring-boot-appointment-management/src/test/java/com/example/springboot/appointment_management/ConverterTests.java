package com.example.springboot.appointment_management;


import com.example.springboot.appointment_management.converter.PatientConverter;
import com.example.springboot.appointment_management.dto.PatientDto;
import com.example.springboot.appointment_management.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConverterTests {

    @Test
    void entityToDto_convertsPatientEntityToPatientDto() {
        Patient patient = new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        PatientDto patientDto = new PatientConverter().entityToDto(patient);
        assertEquals("Sammy",patientDto.getFirstName());
    }

    @Test
    void DtoToEntity_convertsPatientDtoToPatientEntity() {
        PatientDto patientDto = new PatientDto(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        Patient patient = new PatientConverter().dtoToEntity(patientDto);
        assertEquals("Sammy",patient.getFirstName());
    }


}
