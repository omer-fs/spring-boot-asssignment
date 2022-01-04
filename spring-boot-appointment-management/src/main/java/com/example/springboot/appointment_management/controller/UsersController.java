package com.example.springboot.appointment_management.controller;


import com.example.springboot.appointment_management.converter.UsersConverter;
import com.example.springboot.appointment_management.dto.UsersDto;
import com.example.springboot.appointment_management.entity.Authorities;
import com.example.springboot.appointment_management.entity.Patient;
import com.example.springboot.appointment_management.entity.Users;
import com.example.springboot.appointment_management.service.AuthoritiesService;
import com.example.springboot.appointment_management.service.PatientService;
import com.example.springboot.appointment_management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;
    private final PatientService patientService;


    @Autowired
    public UsersController(UsersService theUsersService, AuthoritiesService theAuthoritiesService, PatientService thePatient) {
        usersService = theUsersService;
        authoritiesService = theAuthoritiesService;
        patientService = thePatient;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Users theUser = new Users();

        theModel.addAttribute("user", theUser);

        return "/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") UsersDto usersDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "/user-form";

        //convert dto to entity
        Users theUser = new UsersConverter().dtoToEntity(usersDto);

        Authorities theAuthorities = new Authorities();
        theAuthorities.setUsername(theUser.getUsername());
        theAuthorities.setAuthority("ROLE_PATIENT");

        // save the user and authority
        theUser.setEnabled((short) 1);
        theUser.addAuthority(theAuthorities);
        usersService.save(theUser);
        authoritiesService.save(theAuthorities);

        // use a redirect to prevent duplicate submissions
        return "redirect:/loginPage?user=true";
    }

    @GetMapping("/showPatientDetails")
    public String showPatientDetails(Authentication authentication) {

        String username = authentication.getName();
        // get the patient from the service
        Patient thePatient = patientService.findPatientByEmail(username);

        // send over to our form
        return "redirect:/patients/showPatientDetails?patientId=" + thePatient.getId();
    }
}
