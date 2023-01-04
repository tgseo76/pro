package com.example.project.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String resultCode;
    private T result;

    public Response(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public Response() {
    }


    public Response<T> response(String resultCode, T result){
        Response<T> response = new Response<>(resultCode,result);
        return response;
    }


}
