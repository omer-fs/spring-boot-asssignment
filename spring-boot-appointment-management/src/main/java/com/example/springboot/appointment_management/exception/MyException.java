package com.example.springboot.appointment_management.exception;

public class MyException extends RuntimeException {
    public MyException (String message) {
        super(message);
    }
}
