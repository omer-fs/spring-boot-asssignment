package com.example.springboot.appointment_management;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.springboot.appointment_management.dao.AppointmentRepository;
import com.example.springboot.appointment_management.dao.AuthoritiesRepository;
import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.dao.UsersRepository;
import com.example.springboot.appointment_management.dto.AppointmentDto;
import com.example.springboot.appointment_management.entity.Appointment;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.exception.MyException;
import com.example.springboot.appointment_management.service.AppointmentService;
import com.example.springboot.appointment_management.service.AuthoritiesService;
import com.example.springboot.appointment_management.service.PatientService;
import com.example.springboot.appointment_management.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @MockBean
    private UsersRepository usersRepository;

    @MockBean
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

    @Test
    void addAppointmentPatient_Test() {
        Patient patient = new Patient(1,"Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        Appointment appointment = new Appointment("Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        patient.addAppointment(appointment);
        assertEquals(1,patient.getAppointments().size());
    }

    @Test
    void appointmentPatient_Test() {
        Patient patient=new Patient();
        Appointment appointment1 = new Appointment("Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        Appointment appointment2 = new Appointment("Dr. Samuel Jackson", "11/01/2022","10:30 AM to 12:30 PM","Stomach");
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        patient.setAppointments(appointments);
        patient.addAppointment(appointment2);
        assertEquals(2,patient.getAppointments().size());
    }

    @Test
    void toStringPatient_ConvertsToString() {
        assertFalse(new Patient().toString().contains("@$"));
    }

    @Test
    void toStringAppointment_ConvertsToString() {
        assertFalse(new Appointment().toString().contains("@$"));
    }

    @Test
    void findAll_getAllPatients() {
        when(patientRepository.findAll()).thenReturn(Stream.of(
                new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655"),
                new Patient(2, "Bruce", "Henry", "bruce@gmail.com", "34", "8765512349")
        ).collect(Collectors.toList()));
        assertEquals(2,patientService.findAllPatients().size());
    }

    @Test
    void findById_getPatientWithId() {
        Patient patient = new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        Optional<Patient> patientById = Optional.of(patient);
        when(patientRepository.findById(1)).thenReturn(patientById);
        assertEquals(patientService.findPatientById(1), patient);
    }

    @Test
    void findById_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> {
            patientService.findPatientById(2);
        });
        String expectedMessage = "Could not find the Patient Id - 2";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void findByEmail_getPatientWithId() {
        Patient patient = new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        Optional<Patient> patientByEmail = Optional.of(patient);
        when(patientRepository.findByEmail("sammy@gmail.com")).thenReturn(patientByEmail);
        assertEquals(patientService.findPatientByEmail("sammy@gmail.com"), patient);
    }

    @Test
    void findByEmail_exceptionTest() {
        Exception exception = assertThrows(MyException.class, () -> {
            patientService.findPatientByEmail("sammy@gmail.com");
        });
        String expectedMessage = "Could not find the Patient - sammy@gmail.com";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void save_savePatient() {
        Patient patient = new Patient(1,"Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        patientService.savePatient(patient);
        verify(patientRepository,times(1)).save(patient);
    }

    @Test
    void deleteById_deletePatientWithId() {
        patientService.deletePatientById(1);
        verify(patientRepository,times(1)).deleteById(1);
    }

    @Test
    void appointmentId_Test() {
        Appointment appointment = new Appointment();
        appointment.setId(1);
        assertEquals(1, appointment.getId());
    }

    @Test
    void doctorName_Test() {
        Appointment appointment = new Appointment();
        appointment.setDoctorName("Dr. Samuel Jackson");
        assertEquals("Dr. Samuel Jackson",appointment.getDoctorName());
    }

    @Test
    void appointmentDate_Test() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate("11/12/2021");
        assertEquals("11/12/2021",appointment.getAppointmentDate());
    }

    @Test
    void appointmentTime_Test() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime("10:30 AM to 12:30 PM");
        assertEquals("10:30 AM to 12:30 PM",appointment.getAppointmentTime());
    }

    @Test
    void reason_Test() {
        Appointment appointment = new Appointment();
        appointment.setReason("Fever");
        assertEquals("Fever",appointment.getReason());
    }

    @Test
    void save_saveAppointment() {
        Appointment appointment = new Appointment("Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        appointmentService.saveAppointment(appointment);
        verify(appointmentRepository,times(1)).save(appointment);
    }

    @Test
    void delete_deleteAppointmentWithId() {
        appointmentService.deleteAppointmentById(1);
        verify(appointmentRepository,times(1)).deleteById(1);
    }


}
