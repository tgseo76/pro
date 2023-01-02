package com.example.project.controller;

import com.example.project.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {
    HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    //    http://localhost:8080/swagger-ui/index.html
    @GetMapping("/hello")
    public String hello() {
        return "서태건";
    }

    @GetMapping("/hello/{num}")
    public int cal(@PathVariable int num){
        return helloService.num(num);
    }

    @GetMapping("/hello/test")
    public String test(){
        return "test";
    }

}
