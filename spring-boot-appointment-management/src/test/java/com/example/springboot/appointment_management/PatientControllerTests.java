package com.example.springboot.appointment_management;


import com.example.springboot.appointment_management.controller.PatientController;
import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PatientControllerTests {

    private MockMvc mockMvc;

    PatientController patientController;

    @Autowired
    PatientService patientService;

    @MockBean
    PatientRepository patientRepository;

    @BeforeEach
    void setup() {
        patientController = new PatientController(patientService);
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }


    @Test
    void listPatient_displaysAllPatients() throws Exception {
        Patient patient1 = new Patient(1, "Sammy", "William", "sammy@gmail.com", "21", "1234987655");

        Patient patient2 = new Patient(2, "Bruce", "Henry", "Bruce@gmail.com", "34", "8765512349");

        when(patientService.findAllPatients()).thenReturn(Arrays.asList(patient1, patient2));

        this.mockMvc.perform(get("/patients/list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("patients", hasSize(2)))
                .andExpect(view().name("patients/list-patients"));
    }


}
