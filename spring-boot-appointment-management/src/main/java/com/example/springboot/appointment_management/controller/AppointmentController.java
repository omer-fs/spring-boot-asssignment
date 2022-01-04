package com.example.springboot.appointment_management.controller;


import com.example.springboot.appointment_management.converter.AppointmentConverter;
import com.example.springboot.appointment_management.dto.AppointmentDto;
import com.example.springboot.appointment_management.entity.Appointment;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.service.AppointmentService;
import com.example.springboot.appointment_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;


    static List<String> doctorList;
    static {
        doctorList = new ArrayList<>();
        doctorList.add("Dr. Samuel Jackson");
        doctorList.add("Dr. David Backer");
        doctorList.add("Dr. William Henry");
    }


    static List<String> timeSlotList;
    static {
        timeSlotList = new ArrayList<>();
        timeSlotList.add("10:30 AM to 12:30 PM");
        timeSlotList.add("01:30 PM to 03:30 PM");
        timeSlotList.add("04:30 PM to 06:00 PM");
    }

    static final String VIEW_PAGE="appointments/appointment-form";
    static final String DOCTORLIST_CONST="doctorList";
    static final String TIMESLOTLIST_CONST="timeSlotList";

    @Autowired
    public AppointmentController(AppointmentService theAppointmentService, PatientService thePatientService) {
        appointmentService = theAppointmentService;
        patientService = thePatientService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listAppointments(@RequestParam("patientId") int thePatientId,
                               Model theModel) {

        // get the appointment from the service
        Patient thePatient = patientService.findPatientById(thePatientId);
        List<Appointment> theAppointments = thePatient.getAppointment();

        // set appointment as a model attribute to pre-populate the form
        theModel.addAttribute("appointments", theAppointments);

        // send over to our form
        return "appointments/list-appointments";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam("patientId") int thePatientId, Model theModel) {

        // create model attribute to bind form data
        Appointment theAppointment = new Appointment();

        theModel.addAttribute("appointment", theAppointment);
        theModel.addAttribute("patientId",thePatientId);

        theModel.addAttribute(DOCTORLIST_CONST, doctorList);
        theModel.addAttribute(TIMESLOTLIST_CONST, timeSlotList);
        return VIEW_PAGE;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("patientId") int thePatientId, @RequestParam("appointmentId") int theId,
                                    Model theModel) {

        // get the appointment from the service
        Appointment theAppointment = appointmentService.findAppointmentById(theId);

        // set patient as a model attribute to pre-populate the form
        theModel.addAttribute("appointment", theAppointment);
        theModel.addAttribute("patientId",thePatientId);

        theModel.addAttribute(DOCTORLIST_CONST, doctorList);
        theModel.addAttribute(TIMESLOTLIST_CONST, timeSlotList);
        // send over to our form
        return VIEW_PAGE;

    }

    @PostMapping("/save")
    public String saveAppointment(@RequestParam("patientId") int thePatientId, @Valid @ModelAttribute("appointment") AppointmentDto appointmentDto, BindingResult bindingResult,  Model theModel) {

        // save the appointment

        if(bindingResult.hasErrors()) {
            theModel.addAttribute(DOCTORLIST_CONST, doctorList);
            theModel.addAttribute(TIMESLOTLIST_CONST, timeSlotList);
            return VIEW_PAGE;
        }

        //convert dto to entity
        Appointment theAppointment = new AppointmentConverter().dtoToEntity(appointmentDto);

        Patient thePatient = patientService.findPatientById(thePatientId);
        thePatient.addAppointment(theAppointment);

        appointmentService.saveAppointment(theAppointment);

        // use a redirect to prevent duplicate submissions
        return "redirect:/appointments/list?patientId="+thePatientId;
    }

    @GetMapping("/delete")
    public String deleteAppointment(@RequestParam("patientId") int thePatientId, @RequestParam("appointmentId") int theId) {

        // delete the patient
        appointmentService.deleteAppointmentById(theId);

        // redirect
        return "redirect:/appointments/list?patientId="+thePatientId;

    }

}
