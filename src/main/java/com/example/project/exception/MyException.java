package com.example.project.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class MyException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;



}