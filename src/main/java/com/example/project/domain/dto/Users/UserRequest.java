package com.example.project.domain.dto.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequest {
    private String userName;
    private String password;
}
