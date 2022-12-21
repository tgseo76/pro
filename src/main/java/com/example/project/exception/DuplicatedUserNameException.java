package com.example.project.exception;


public class DuplicatedUserNameException extends RuntimeException{

    public DuplicatedUserNameException() {
    }

    public DuplicatedUserNameException(String message) {
        super(message);
    }


}
