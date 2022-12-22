package com.example.project.service;

import com.example.project.domain.entity.User;
import com.example.project.exception.MyException;
import com.example.project.repository.UserRepository;
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

    //회원가입
    public String join(String name, String password){
        //중복확인
        userRepository.findByUserName(name)
                .ifPresent(user -> {
                    throw new MyException(MyException.ErrorCode.DUPLICATED_USER_NAME, name + "은 이미 있습니다. service join 테스트");
                });
        //저장
        User user= User.builder()
                .userName(name)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);
        return "SUCCESS";
    }

        //로그인
        public String login(String name , String password){
        return "";
    }
}
