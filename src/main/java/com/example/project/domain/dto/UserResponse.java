package com.example.project.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse<T> {
    private String resultCode;
    private T result;

    public UserResponse(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public UserResponse() {
    }


    public UserResponse<T> userResponse(String resultCode,T result){
        UserResponse<T> userResponse = new UserResponse<>(resultCode,result);
        return userResponse;
    }


}
