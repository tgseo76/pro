package com.example.project.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Response;

@Getter
@Setter
public class UserResponse<T> {
    private String resultCode;
    private T result;

    public UserResponse() {
    }

    public UserResponse(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public static <T>UserResponse<T> success(T result){
        UserResponse<T> userResponse=new UserResponse("SUCCESS",result);
        return userResponse;
    }
}
