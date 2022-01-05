package com.example.springboot.appointment_management.controller;


import com.example.springboot.appointment_management.converter.PatientConverter;
import com.example.springboot.appointment_management.dto.PatientDto;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    static final String PATIENT="patient";
    static final String VIEW_PAGE="patients/patient-form";

    @Autowired
    public PatientController(PatientService thePatientService) {
        patientService = thePatientService;
    }


    @GetMapping("/list")
    public String listPatients(Model theModel) {

        // get patients from database
        List<Patient> thePatients = patientService.findAllPatients();

        //add to spring model
        theModel.addAttribute("patients", thePatients);

        return "patients/list-patients";
    }


    @GetMapping("/showPatientDetails")
    public String showPatientDetails(@RequestParam("patientId") int theId,
                                    Model theModel) {

        // get the patient from the service
        Patient thePatient = patientService.findPatientById(theId);

        // set patient as a model attribute to pre-populate the form
        theModel.addAttribute(PATIENT, thePatient);

        // send over to our form
        return "patients/patient-details";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Patient thePatient = new Patient();

        theModel.addAttribute(PATIENT, thePatient);


        return VIEW_PAGE;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("patientId") int theId,
                                    Model theModel) {

        // get the patient from the service
        Patient thePatient = patientService.findPatientById(theId);

        // set patient as a model attribute to pre-populate the form
        theModel.addAttribute(PATIENT, thePatient);


        // send over to our form
        return VIEW_PAGE;
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("patient") PatientDto patientDto, BindingResult bindingResult, Model theModel, Authentication authentication) {

        String username = authentication.getName();

        if (bindingResult.hasErrors()) {
            return VIEW_PAGE;
        }
        else {
            //convert dto to entity
            Patient thePatient = new PatientConverter().dtoToEntity(patientDto);

            // save the patient
            patientService.savePatient(thePatient);

            if(username=="receptionist@admin.com")
                return "redirect:/patients/list";


            return "redirect:/patients/showPatientDetails?patientId=" + thePatient.getId();

            // use a redirect to prevent duplicate submissions



        }
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam("patientId") int theId) {

        // delete the patient
        patientService.deletePatientById(theId);

        // redirect
        return "redirect:/patients/list";

    }
}
