package com.example.springboot.appointment_management.converter;


import com.example.springboot.appointment_management.dto.AppointmentDto;
import com.example.springboot.appointment_management.entity.Appointment;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper
public class AppointmentConverter {

    public AppointmentDto entityToDto(Appointment appointment) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(appointment, AppointmentDto.class);
    }

    public Appointment dtoToEntity(AppointmentDto appointmentDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(appointmentDto, Appointment.class);
    }

    public List<AppointmentDto> entityToDto(List<Appointment> appointmentList) {
        return appointmentList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Appointment> dtoToEntity(List<AppointmentDto> appointmentDtoList) {
        return appointmentDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
