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
    public PostResponse write(PostRequest dto, String name){
        User user = userRepository.findByUserName(name).orElseThrow(()->new MyException(ErrorCode.USERNAME_NOT_FOUND,name+"이 없습니다.(postser.write"));

        Post post = Post.builder()
                .user(user)
                .body(dto.getBody())
                .title(dto.getTitle())
                .build();

        postRepository.save(post);

        PostResponse postResponse = new PostResponse("포스트 등록 완료",post.getId());
        return postResponse;
    }

}
