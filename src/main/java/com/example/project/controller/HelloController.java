package com.example.project.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    http://localhost:8080/swagger-ui/index.html
    @GetMapping("/api/v1/hello")
    public String hello() {
        return "hello";
    }

}
