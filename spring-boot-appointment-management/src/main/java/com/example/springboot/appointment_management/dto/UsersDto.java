package com.example.springboot.appointment_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    @NotEmpty(message = "Should not be empty")
    private String username;

    @NotEmpty(message = "Should not be empty")
    @Size(min=5, message = "Password should be minimum 5 characters")
    private String password;

    private short enabled;

}
