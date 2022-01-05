package com.example.springboot.appointment_management;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springboot.appointment_management.dao.AppointmentRepository;
import com.example.springboot.appointment_management.dao.AuthoritiesRepository;
import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.dao.UsersRepository;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.service.AppointmentService;
import com.example.springboot.appointment_management.service.AuthoritiesService;
import com.example.springboot.appointment_management.service.PatientService;
import com.example.springboot.appointment_management.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AppointmentManagementApplicationTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;


    @Test
    void patientId_Test() {
        Patient patient = new Patient();
        patient.setId(1);
        assertEquals(1, patient.getId());
    }

    @Test
    void firstName_Test() {
        Patient patient = new Patient();
        patient.setFirstName("Sammy");
        assertEquals("Sammy", patient.getFirstName());
    }

    @Test
    void lastName_Test() {
        Patient patient = new Patient();
        patient.setLastName("William");
        assertEquals("William", patient.getLastName());
    }

    @Test
    void email_Test() {
        Patient patient = new Patient();
        patient.setEmail("sammy@gmail.com");
        assertEquals("sammy@gmail.com", patient.getEmail());
    }

    @Test
    void age_Test() {
        Patient patient = new Patient();
        patient.setAge("21");
        assertEquals("21", patient.getAge());
    }

    @Test
    void phoneNumber_Test() {
        Patient patient = new Patient();
        patient.setPhoneNumber("1234987655");
        assertEquals("1234987655", patient.getPhoneNumber());
    }
}
