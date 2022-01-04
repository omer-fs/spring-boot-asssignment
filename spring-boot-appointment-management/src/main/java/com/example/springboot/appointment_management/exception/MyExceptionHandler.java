package com.example.springboot.appointment_management.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public String exceptionHandlerMethod(RuntimeException exception, Model model){
        model.addAttribute("message",exception.getMessage());
        return "error-page";
    }


    @ExceptionHandler
    public String exceptionHandlerMethod(Exception exception, Model model) {
        model.addAttribute("message",exception.getMessage());
        return "error-page";
    }
}
