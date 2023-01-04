package com.example.project.service;

import com.example.project.domain.dto.Post.PostRequest;
import com.example.project.domain.dto.Post.PostResponse;
import com.example.project.domain.entity.Post;
import com.example.project.domain.entity.User;
import com.example.project.exception.ErrorCode;
import com.example.project.exception.MyException;
import com.example.project.repository.PostRepository;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    //게시판 작성



}
