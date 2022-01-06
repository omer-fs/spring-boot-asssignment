package com.example.springboot.appointment_management;



import com.example.springboot.appointment_management.controller.AppointmentController;
import com.example.springboot.appointment_management.dao.AppointmentRepository;
import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.entity.Appointment;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.service.AppointmentService;
import com.example.springboot.appointment_management.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class AppointmentControllerTests {
    private MockMvc mockMvc;

    AppointmentController appointmentController;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @MockBean
    AppointmentRepository appointmentRepository;

    @MockBean
    PatientRepository patientRepository;

    @BeforeEach
    void setup()
    {
        appointmentController = new AppointmentController(appointmentService, patientService);
        mockMvc= MockMvcBuilders.standaloneSetup(appointmentController).build();
    }


    @Test
    void listAppointments_displaysAllPatients() throws Exception {

        Appointment appointment1 = new Appointment("Dr. Samuel Jackson", "10/12/2022","10:30 AM to 12:30 PM","Fever");
        Appointment appointment2 = new Appointment("Dr. Samuel Jackson", "11/01/2022","10:30 AM to 12:30 PM","Stomach");

        Patient patient = new Patient(1,"Sammy", "William", "sammy@gmail.com", "21", "1234987655");
        patient.setAppointments(Arrays.asList(appointment1, appointment2));

        Optional<Patient> patientById = Optional.of(patient);
        when(patientRepository.findById(1)).thenReturn(patientById);

        this.mockMvc.perform(get("/appointments/list?patientId={patientId}",1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("appointments",hasSize(2)))
                .andExpect(view().name("appointments/list-appointments"));
    }
}
