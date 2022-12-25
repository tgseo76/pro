package com.example.project.domain.dto;

import com.example.project.domain.entity.User;
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

    public static JoinResponse of(User saved) {
        JoinResponse joinResponse = new JoinResponse(saved.getUserId(), saved.getUserName());
        return joinResponse;
    }
}
