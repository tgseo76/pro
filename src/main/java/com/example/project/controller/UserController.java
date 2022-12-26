package com.example.project.controller;

import com.example.project.domain.dto.JoinResponse;
import com.example.project.domain.dto.LoginResponse;
import com.example.project.domain.dto.UserRequest;
import com.example.project.domain.dto.UserResponse;
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
    public ResponseEntity<UserResponse<JoinResponse>> join(@RequestBody UserRequest dto){
        JoinResponse joinResponse= userService.join(dto.getUserName(), dto.getPassword());
        return ResponseEntity.ok().body(UserResponse.success(joinResponse));
    }
//    {
//        "resultCode": "SUCCESS",
//            "result":{
//        "userId": 2,
//                "userName": "test2"
//    }
//    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse<LoginResponse>> login(@RequestBody UserRequest dto){
        LoginResponse loginResponse = new LoginResponse(userService.login(dto.getUserName(), dto.getPassword()));
        return ResponseEntity.ok().body(UserResponse.success(loginResponse));
    }
//    {
//        "resultCode": "SUCCESS",
//            "result":{
//        "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSh0b2tlbi5jcmVhdGVUb2tlbikiOiJ0ZXN0MSIsImlhdCI6MTY3MTk5OTM1NSwiZXhwIjoxNjcyMDg1NzU1fQ.niEp__CqL0yqCxF4rbiIdzCwUrK9sDM_rQKnNlXAznc"
//    }
//    }

}
