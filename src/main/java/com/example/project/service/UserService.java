package com.example.project.service;

import com.example.project.domain.dto.JoinResponse;
import com.example.project.domain.entity.User;
import com.example.project.exception.MyException;
import com.example.project.repository.UserRepository;
import com.example.project.utils.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}") // ${jwt.token.secret} ==> yml파일 어노테이션 라이브러리 롬복 x 스프링프레임워크
    private String key;
    private Long expireTimeMs= 1000*60*60*24L;  //1초*60*60*24 ==>하루

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    //회원가입
    public JoinResponse join(String name, String password) {
        //중복확인.
//        userRepository.findByUserName(name)
//                .ifPresent(user -> {
//                    throw new MyException(MyException.ErrorCode.DUPLICATED_USER_NAME, name + "은 이미 있습니다. service join 테스트");
//                });
                if(userRepository.findByUserName(name).isPresent()){
                    throw new MyException(MyException.ErrorCode.DUPLICATED_USER_NAME, name + "은 이미 있습니다. service join 테스트");
                }
        //저장
        User user = User.builder()
                .userName(name)
                .password(encoder.encode(password))
                .build();
        userRepository.save(user);

        JoinResponse joinResponse = new JoinResponse(user.getUserId(),user.getUserName());

        return joinResponse;
    }

    //로그인
    public String login(String name, String password) {
        // 없는 회원   orElseThrow() ==> 없을때 에러
        User user = userRepository.findByUserName(name).orElseThrow(()->new MyException(MyException.ErrorCode.USERNAME_NOT_FOUND,name+"이 없습니다(service.login)"));
//                Optional<User> user = userRepository.findByUserName(name);
//                if(user.isEmpty()){
//                    throw new MyException(MyException.ErrorCode.USERNAME_NOT_FOUND,name+"이 없습니다(service.login)");
//                }

        //pw오류
        if(!encoder.matches(password,user.getPassword())){ // (로그인시 받는 패스워드먼저,  db에 저장된 암호화 된 pw는 2번째)
            throw new MyException(MyException.ErrorCode.INVALID_PASSWORD,"패스워드잘못(service.login)");
        }


        // 토큰 발행
        String token = JwtToken.createToken(user.getUserName(),key,expireTimeMs);
        return token;
    }

}
