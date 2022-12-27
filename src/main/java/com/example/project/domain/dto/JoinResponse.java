package com.example.project.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinResponse {
    private Long userId;
    private String userName;

    public JoinResponse() {
    }
    public JoinResponse(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }


}
