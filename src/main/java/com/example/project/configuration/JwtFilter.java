package com.example.project.configuration;

import com.example.project.domain.entity.User;
import com.example.project.service.UserService;
import com.example.project.utils.JwtToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @Slf4j
    @RequiredArgsConstructor
    public class JwtFilter extends OncePerRequestFilter {

        private final String secretKey;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authorizationHeader:{}", authorizationHeader);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        //토큰만 분리해야한다
        String token;
        try {
            token = authorizationHeader.split(" ")[1];
        } catch (Exception e) {//요청시 token이 없으면
            log.error("token 추출에 실패 했습니다");
            filterChain.doFilter(request, response);
            return;
        }

                //JWTTokenUtil.
        if (JwtToken.isExpired(token, secretKey)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Token에서 userName 꺼내기
        String userName = JwtToken.getUserName(token, secretKey);
        log.info("username:{}", userName);

        //userDetail 가져오기
        User user = userService.getUserByUserName(userName);
        log.info("userRole:{}", user.getRole());

        //문 열어주기, role 바인딩
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), null, List.of(new SimpleGrantedAuthority(user.getRole().name()))); //권한을 여러개 줄 수 있다
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);//권한 부여 (이 문을 통과할 수 있다는 것)
        filterChain.doFilter(request, response);

    }
}
