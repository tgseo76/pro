package com.example.project.controller;

import com.example.project.domain.dto.Users.JoinResponse;
import com.example.project.domain.dto.Users.LoginResponse;
import com.example.project.domain.dto.Users.UserRequest;
import com.example.project.domain.dto.Response;
import com.example.project.service.UserService;
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
    public ResponseEntity<Response<JoinResponse>> join(@RequestBody UserRequest dto){
        JoinResponse joinResponse =userService.join(dto.getUserName(), dto.getPassword());
        Response<JoinResponse> response = new Response<>("SUCCESS",joinResponse);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponse>> login(@RequestBody UserRequest dto){
        String token = userService.login(dto.getUserName(), dto.getPassword());
        LoginResponse loginResponse = new LoginResponse(token);
        Response<LoginResponse> response = new Response<>("SUCCESS",loginResponse);
        return ResponseEntity.ok().body(response);
    }


//    {
//        "resultCode": "SUCCESS",
//            "result":{
//        "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSh0b2tlbi5jcmVhdGVUb2tlbikiOiJhYSIsImlhdCI6MTY3MjEyMzA5MSwiZXhwIjoxNjcyMjA5NDkxfQ.mP6xk_1AthztFqqcEKgYashN5FBQUAuPWGnvel77TYQ"
//    }
//    }

}
