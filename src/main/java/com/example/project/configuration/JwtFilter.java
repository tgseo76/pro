package com.example.project.configuration;

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

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final String secretKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("auth : {}",authorization);

        if(authorization==null || !authorization.startsWith("Bearer ")){
            log.error("authorization을 잘못 보냈습니다");
            filterChain.doFilter(request,response);
            return;
        }
        
        //토큰 꺼내기
        String token = authorization.split(" ")[1];

        //토큰 expired 체크
        if(JwtToken.isExpired(token,secretKey)){
            log.error("토큰이 만료");
            filterChain.doFilter(request,response);
            return;
        }

        //username 토큰에서 거내기
        String userName=JwtToken.getUserName(token,secretKey);
        log.info("username : {}",userName);

        //권한
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userName,null, List.of(new SimpleGrantedAuthority("USER")));

        //Detail
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
