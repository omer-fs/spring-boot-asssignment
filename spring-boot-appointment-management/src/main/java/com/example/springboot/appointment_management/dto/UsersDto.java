package com.example.springboot.appointment_management.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsersDto {

    @NotEmpty(message = "Should not be empty")
    private String username;

    @NotEmpty(message = "Should not be empty")
    @Size(min=5, message = "Password should be minimum 5 characters")
    private String password;

    private short enabled;


    // no args constructor
    public UsersDto() {
    }

    // all args constructor

    public UsersDto(String username, String password, short enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }
}
