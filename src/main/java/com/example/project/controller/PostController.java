package com.example.project.controller;

import com.example.project.domain.dto.Post.PostRequest;
import com.example.project.domain.dto.Post.PostResponse;
import com.example.project.domain.dto.Response;
import com.example.project.domain.dto.Users.JoinResponse;
import com.example.project.domain.entity.Post;
import com.example.project.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    //"Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSh0b2tlbi5jcmVhdGVUb2tlbikiOiJ6eGN2IiwiaWF0IjoxNjczMjI4OTQ4LCJleHAiOjE2NzMzMTUzNDh9.ytQZdDKFi5Rycye1rSf-7oCAnzCCVGxaqoHLsdlkuAg"

    //    http://localhost:8080/swagger-ui/index.html
    private final  PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    
    //포스트 등록
        @PostMapping("")
//    ResponseEntity<Response<PostResponse>>
        public ResponseEntity<Response<PostResponse>> add(@RequestBody PostRequest postRequest, Authentication authentication){
            PostResponse postResponse = postService.addPost(postRequest.getTitle(),postRequest.getBody(),authentication.getName());
            Response<PostResponse> response= new Response<>("SUCCESS",postResponse);
        return ResponseEntity.ok().body(response);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<PostResponse>> del(@PathVariable Long id,Authentication authentication){
        PostResponse postResponse = postService.delPost(id,authentication.getName());
        Response<PostResponse> response = new Response<>("SUCCESS",postResponse);
        return ResponseEntity.ok().body(response);
    }





}
