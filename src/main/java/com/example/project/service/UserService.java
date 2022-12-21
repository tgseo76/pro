package com.example.project.service;

import com.example.project.domain.entity.User;
import com.example.project.exception.DuplicatedUserNameException;
import com.example.project.repository.UserRepository;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public String join(String name, String password){
        //중복확인
        userRepository.findByUserName(name)
                .ifPresent(user -> {
                    throw new DuplicatedUserNameException(name+"는 회원중복");
                });

        //저장
        User user= User.builder()
                .userName(name)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);


        return "SUCCESS";
    }
}
