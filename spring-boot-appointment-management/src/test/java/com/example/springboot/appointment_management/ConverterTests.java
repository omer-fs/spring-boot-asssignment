package com.example.springboot.appointment_management;


import com.example.springboot.appointment_management.converter.AppointmentConverter;
import com.example.springboot.appointment_management.converter.PatientConverter;
import com.example.springboot.appointment_management.converter.UsersConverter;
import com.example.springboot.appointment_management.dto.AppointmentDto;
import com.example.springboot.appointment_management.dto.PatientDto;
import com.example.springboot.appointment_management.dto.UsersDto;
import com.example.springboot.appointment_management.entity.Appointment;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.entity.Users;
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

    @Test
    void entityToDto_convertsPatientEntityLisToPatientDtoList() {
        Patient patient1 = new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        Patient patient2 = new Patient(2, "Bruce", "Henry", "Bruce@gmail.com", "34", "8765512349");
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient1);
        patientList.add(patient2);
        List<PatientDto> patientDtoList = new PatientConverter().entityToDto(patientList);
        assertEquals(2,patientDtoList.size());
    }

    @Test
    void dtoToEntity_convertsPatientDtoListToPatientEntityList() {
        PatientDto patientDto1 = new PatientDto(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        PatientDto patientDto2 = new PatientDto(2, "Bruce", "Henry", "Bruce@gmail.com", "34", "8765512349");
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientDtoList.add(patientDto1);
        patientDtoList.add(patientDto2);
        List<Patient> patientList = new PatientConverter().dtoToEntity(patientDtoList);
        assertEquals(2,patientList.size());
    }

    @Test
    void entityToDto_convertsAppointmentEntityToAppointmentDto() {
        Appointment appointment = new Appointment(1,"Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        AppointmentDto appointmentDto = new AppointmentConverter().entityToDto(appointment);
        assertEquals("Fever",appointmentDto.getReason());
    }

    @Test
    void DtoToEntity_convertsAppointmentDtoToAppointmentEntity() {
        AppointmentDto appointmentDto = new AppointmentDto(1,"Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        Appointment appointment = new AppointmentConverter().dtoToEntity(appointmentDto);
        assertEquals("Fever",appointment.getReason());
    }

    @Test
    void entityToDto_convertsAppointmentEntityListToAppointmentDtoList() {
        Appointment appointment1 = new Appointment("Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        Appointment appointment2 = new Appointment("Dr. Samuel Jackson", "11/01/2022","10:30 AM to 12:30 PM","Stomach");
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment1);
        appointmentList.add(appointment2);
        List<AppointmentDto> appointmentDtoList = new AppointmentConverter().entityToDto(appointmentList);
        assertEquals(2,appointmentDtoList.size());
    }

    @Test
    void dtoToEntity_convertsAppointmentDtoListToAppointmentEntityList() {
        AppointmentDto appointmentDto1 = new AppointmentDto(1,"Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        AppointmentDto appointmentDto2 = new AppointmentDto(1,"Dr. Samuel Jackson", "11/01/2022","10:30 AM to 12:30 PM","Stomach");
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        appointmentDtoList.add(appointmentDto1);
        appointmentDtoList.add(appointmentDto2);
        List<Appointment> appointmentList = new AppointmentConverter().dtoToEntity(appointmentDtoList);
        assertEquals(2,appointmentList.size());
    }

    @Test
    void entityToDto_convertsUsersEntityToUsersDto() {
        Users users = new Users("sammy@gmail.com", "abc123", (short) 1);
        UsersDto usersDto = new UsersConverter().entityToDto(users);
        assertEquals("sammy@gmail.com",usersDto.getUsername());
    }

    @Test
    void DtoToEntity_convertsUsersDtoToUsersEntity() {
        UsersDto usersDto = new UsersDto("sammy@gmail.com", "abc123", (short) 1);
        Users users = new UsersConverter().dtoToEntity(usersDto);
        assertEquals("sammy@gmail.com",users.getUsername());
    }

    @Test
    void entityToDto_convertsUsersEntityListToUsersDtoList() {
        Users users1 = new Users("sammy@gmail.com", "abc123", (short) 1);
        Users users2 = new Users("bruce@gmail.com", "pqr123", (short) 1);
        List<Users> usersList = new ArrayList<>();
        usersList.add(users1);
        usersList.add(users2);
        List<UsersDto> usersDtoList = new UsersConverter().entityToDto(usersList);
        assertEquals(2,usersDtoList.size());
    }

    @Test
    void dtoToEntity_convertsUsersDtoListToUsersEntityList() {
        UsersDto usersDto1 = new UsersDto("sammy@gmail.com", "abc123", (short) 1);
        UsersDto usersDto2 = new UsersDto("bruce@gmail.com", "pqr123", (short) 1);
        List<UsersDto> usersDtoList = new ArrayList<>();
        usersDtoList.add(usersDto1);
        usersDtoList.add(usersDto2);
        List<Users> usersList = new UsersConverter().dtoToEntity(usersDtoList);
        assertEquals(2,usersList.size());
    }
}
