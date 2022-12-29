package com.example.project.controller;

import com.example.project.domain.dto.JoinResponse;
import com.example.project.domain.dto.LoginResponse;
import com.example.project.domain.dto.UserRequest;
import com.example.project.domain.dto.UserResponse;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
//    ec2-3-35-10-110.ap-northeast-2.compute.amazonaws.com:8080/swagger-ui/index.html
    //    http://localhost:8080/swagger-ui/index.html
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<UserResponse<JoinResponse>> join(@RequestBody UserRequest dto){
        JoinResponse joinResponse =userService.join(dto.getUserName(), dto.getPassword());
        UserResponse<JoinResponse> userResponse = new UserResponse<>("SUCCESS",joinResponse);
        return ResponseEntity.ok().body(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse<LoginResponse>> login(@RequestBody UserRequest dto){
        String token = userService.login(dto.getUserName(), dto.getPassword());
        LoginResponse loginResponse = new LoginResponse(token);
        UserResponse<LoginResponse> userResponse = new UserResponse<>("SUCCESS",loginResponse);
        return ResponseEntity.ok().body(userResponse);
    }


//    {
//        "resultCode": "SUCCESS",
//            "result":{
//        "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSh0b2tlbi5jcmVhdGVUb2tlbikiOiJhYSIsImlhdCI6MTY3MjEyMzA5MSwiZXhwIjoxNjcyMjA5NDkxfQ.mP6xk_1AthztFqqcEKgYashN5FBQUAuPWGnvel77TYQ"
//    }
//    }

}
