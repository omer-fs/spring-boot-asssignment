package com.example.springboot.appointment_management;


import com.example.springboot.appointment_management.dao.AppointmentRepository;
import com.example.springboot.appointment_management.dao.AuthoritiesRepository;
import com.example.springboot.appointment_management.dao.PatientRepository;
import com.example.springboot.appointment_management.dao.UsersRepository;
import com.example.springboot.appointment_management.service.AppointmentService;
import com.example.springboot.appointment_management.service.AuthoritiesService;
import com.example.springboot.appointment_management.service.PatientService;
import com.example.springboot.appointment_management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentManagementApplicationTests {

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
}
