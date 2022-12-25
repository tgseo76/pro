package com.example.project.controller;

import com.example.project.domain.dto.JoinResponse;
import com.example.project.domain.dto.Response;
import com.example.project.domain.dto.UserRequest;
import com.example.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
//    ec2-3-35-10-110.ap-northeast-2.compute.amazonaws.com:8080/swagger-ui/index.html
    //    http://localhost:8080/swagger-ui/index.html
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<Response<JoinResponse>> join(@RequestBody UserRequest dto) {
        JoinResponse joinResponse1 = userService.join(dto.getUserName(), dto.getPassword());
        return ResponseEntity.ok().body(Response.success(joinResponse1));
    }
//
//    {
//        "resultCode": "SUCCESS",
//            "result": {
//        "userId": 5,
//                "userName": "test1"
//    }
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest dto){
        String token = userService.login(dto.getUserName(), dto.getPassword());
        return ResponseEntity.ok().body(token);
    }

//    {
////        "resultCode": "SUCCESS",
////            "result": {
////        "jwt": "eyJhbGciOiJIU",
//    }
//    }


}
