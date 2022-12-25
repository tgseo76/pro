package com.example.project.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Response<T> {
    private String resultCode;
    private T result;

    public Response(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }
 // <T>(파라미터) Response<T>(객체필드)
    public static <T> Response<T> success(T result){
        Response<T> response = new Response("success",result);
        return response;
    }


}
