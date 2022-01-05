package com.example.springboot.appointment_management.dto;

import lombok.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private int id;

    @Size(min = 2, message = "Doctor name should be at least 2 characters")
    private String doctorName;

    @Size(min =6, message = "Date cannot be null")
    private String appointmentDate;

    @Size(min=6, message = "Time cannot be null")
    private String appointmentTime;

    @Size(min=2, message = "Reason should be at least 2 characters")
    private String reason;

}
