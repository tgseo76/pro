package com.example.project.service;

import com.example.project.domain.dto.Post.PostRequest;
import com.example.project.domain.dto.Post.PostResponse;
import com.example.project.domain.entity.Post;
import com.example.project.domain.entity.User;
import com.example.project.domain.entity.UserRole;
import com.example.project.exception.ErrorCode;
import com.example.project.exception.MyException;
import com.example.project.repository.PostRepository;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    //게시판 작성
    public PostResponse addPost(String title, String body,String name){
        User userEntity=userRepository.findByUserName(name).orElseThrow(()-> new MyException(ErrorCode.USERNAME_NOT_FOUND,name));
//        if(userRepository.findByUserName(name).isPresent()){
//            throw new MyException(ErrorCode.USERNAME_NOT_FOUND,name);
//        } else {
//             Optional<User> userentity = userRepository.findByUserName(name);
//        }
//

        Post post = Post.builder()
                .title(title)
                .body(body)
                .user(userEntity)
                .build();
        postRepository.save(post);

        PostResponse postResponse = PostResponse.builder()
                .postId(post.id)
                .message("포스트 등록 완료")
                .build();

        System.out.printf("post = \n",post.id);
        System.out.printf("postRes = \n",postResponse.getPostId());
        return postResponse;
    }





}
