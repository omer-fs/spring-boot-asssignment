package com.example.springboot.appointment_management;

import com.example.springboot.appointment_management.dto.AppointmentDto;
import com.example.springboot.appointment_management.dto.PatientDto;
import com.example.springboot.appointment_management.dto.UsersDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DtoTests {

    @Test
    void patientId_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(1);
        assertEquals(1,patientDto.getId());
    }

    @Test
    void firstName_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName("Sammy");
        assertEquals("Sammy", patientDto.getFirstName());
    }

    @Test
    void lastName_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setLastName("William");
        assertEquals("William", patientDto.getLastName());
    }

    @Test
    void email_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setEmail("sammy@gmail.com");
        assertEquals("sammy@gmail.com", patientDto.getEmail());
    }

    @Test
    void age_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setAge("22");
        assertEquals("22", patientDto.getAge());
    }

    @Test
    void phoneNumber_Test() {
        PatientDto patientDto = new PatientDto();
        patientDto.setPhoneNumber("1234567890");
        assertEquals("1234567890", patientDto.getPhoneNumber());
    }

    @Test
    void patientDtoConstructor_Test() {
        PatientDto patientDto = new PatientDto(1, "Sammy", "William", "sammy@gmail.com", "22","1234567890");
        assertEquals("Sammy", patientDto.getFirstName());
    }

    @Test
    void doctorId_Test() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(1);
        assertEquals(1,appointmentDto.getId());
    }

    @Test
    void doctorName_Test() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDoctorName("Dr. Samuel Jackson");
        assertEquals("Dr. Samuel Jackson",appointmentDto.getDoctorName());
    }

    @Test
    void appointmentDate_Test() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentDate("11/12/2021");
        assertEquals("11/12/2021",appointmentDto.getAppointmentDate());
    }

    @Test
    void appointmentTime_Test() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentTime("10:30 AM to 12:30 PM");
        assertEquals("10:30 AM to 12:30 PM",appointmentDto.getAppointmentTime());
    }

    @Test
    void reason_Test() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setReason("Fever");
        assertEquals("Fever",appointmentDto.getReason());
    }

    @Test
    void appointmentDtoConstructor_Test() {
        AppointmentDto appointmentDto = new AppointmentDto(1, "Dr. Samuel Jackson", "11/12/2021","10:30 AM to 12:30 PM","Fever");
        assertEquals("Dr. Samuel Jackson", appointmentDto.getDoctorName());
    }


    @Test
    void usersUsername_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("sammy@gmail.com");
        assertEquals("sammy@gmail.com", usersDto.getUsername());
    }

    @Test
    void password_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setPassword("abc123");
        assertEquals("abc123", usersDto.getPassword());
    }

    @Test
    void enabled_Test() {
        UsersDto usersDto = new UsersDto();
        usersDto.setEnabled((short)1);
        assertEquals(1, usersDto.getEnabled());
    }

    @Test
    void usersDtoConstructor_Test() {
        UsersDto usersDto = new UsersDto("sammy@gmail.com", "abc123", (short)1);
        assertEquals("sammy@gmail.com", usersDto.getUsername());
    }
}
