package com.example.project.controller;

import com.example.project.domain.dto.Post.PostRequest;
import com.example.project.domain.dto.Post.PostResponse;
import com.example.project.domain.dto.Response;
import com.example.project.domain.entity.Post;
import com.example.project.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    //"Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSh0b2tlbi5jcmVhdGVUb2tlbikiOiJ6eGN2IiwiaWF0IjoxNjczMjI4OTQ4LCJleHAiOjE2NzMzMTUzNDh9.ytQZdDKFi5Rycye1rSf-7oCAnzCCVGxaqoHLsdlkuAg"

    //    http://localhost:8080/swagger-ui/index.html
    private final  PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public String test(@RequestBody PostRequest postRequest, Authentication authentication){
        System.out.println(authentication.getName());
        return authentication.getName();
    }


//    @PostMapping("")
//    public String post(Authentication authentication){
//
//        return authentication.getName();
//    }

}
