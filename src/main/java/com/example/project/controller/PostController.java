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
    //    http://localhost:8080/swagger-ui/index.html
    private final  PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    public ResponseEntity<Response<PostResponse>> post(@RequestBody PostRequest dto, Authentication authentication){
        String name = authentication.getName();
        System.out.println("name = "+name);
        PostResponse postResponse = postService.write(dto,name);
        System.out.println(postResponse);
        Response<PostResponse> response = new Response<>("SUCCESS",postResponse);
        return ResponseEntity.ok().body(response);


    }
//    @PostMapping("")
//    public String post(){
//
//        return "asdf";
//
//
//    }


}




