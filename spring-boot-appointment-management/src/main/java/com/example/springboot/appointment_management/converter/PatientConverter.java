package com.example.springboot.appointment_management.converter;


import com.example.springboot.appointment_management.dto.PatientDto;
import com.example.springboot.appointment_management.entity.Patient;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class PatientConverter {

    public PatientDto entityToDto(Patient patient) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(patient, PatientDto.class);
    }

    public Patient dtoToEntity(PatientDto patientDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(patientDto, Patient.class);
    }

    public List<PatientDto> entityToDto(List<Patient> patientList) {
        return patientList.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    public List<Patient> dtoToEntity(List<PatientDto> patientDtoList) {
        return patientDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
