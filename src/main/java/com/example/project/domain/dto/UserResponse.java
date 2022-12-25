package com.example.project.domain.dto;

public class UserResponse<T> {
    private String resultCode;
    private T result;

    public UserResponse() {
    }

    public UserResponse(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }
}
