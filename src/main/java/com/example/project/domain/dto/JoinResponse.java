package com.example.project.domain.dto;

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
