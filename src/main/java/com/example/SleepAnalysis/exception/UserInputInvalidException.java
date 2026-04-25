package com.example.SleepAnalysis.exception;

public class UserInputInvalidException extends RuntimeException {
    public UserInputInvalidException(String s){
        super(s);
    }
}