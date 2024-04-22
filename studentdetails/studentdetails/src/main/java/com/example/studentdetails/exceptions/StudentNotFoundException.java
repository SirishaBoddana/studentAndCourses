package com.example.studentdetails.exceptions;


public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(){
        super();
    }
    public StudentNotFoundException(String message){
        super(message);
    }

}