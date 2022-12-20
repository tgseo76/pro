package com.example.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/hello1")
    public String hello1() {
        return "hello";
    }

    @GetMapping("/api/hello2")
    public String hello2(@RequestParam String param) {
        return param;
    }
}
