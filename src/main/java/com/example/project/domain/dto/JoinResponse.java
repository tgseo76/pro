package com.example.project.domain.dto;

import com.example.project.domain.entity.User;
import lombok.AllArgsConstructor;
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


    public static JoinResponse of (User user){
        JoinResponse joinResponse = new JoinResponse(user.getUserId(),user.getUserName());
        return joinResponse;
    }

}
