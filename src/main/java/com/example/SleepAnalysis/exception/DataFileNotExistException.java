package com.example.SleepAnalysis.exception;

public class DataFileNotExistException extends RuntimeException {
    public DataFileNotExistException(String s){
        super(s);
    }
}
