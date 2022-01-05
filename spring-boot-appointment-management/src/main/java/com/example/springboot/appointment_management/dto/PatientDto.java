package com.example.springboot.appointment_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {


    private int id;

    @Size(min = 2, message = "First name should be at least 2 characters")
    private String firstName;

    @Size(min = 2,message = "Last Name should be at least 2 characters")
    private String lastName;

    @NotEmpty(message = "Email should not be null")
    private String email;

    @Range(min = 1, max = 100, message = "Age should be between [1-100]")
    private String age;

    @Size(min = 10, message = "Phone Number should be 10 characters")
    private String phoneNumber;

}
