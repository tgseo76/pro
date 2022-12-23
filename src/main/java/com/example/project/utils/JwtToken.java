package com.example.project.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtToken {
    public static String createToken(String name,String key,Long expireTimeMs){
        Claims claims= Jwts.claims(); //map함수
        claims.put("userName(token.createToken)",name);

        return Jwts.builder()
                .setClaims(claims) //클래임지정
                .setIssuedAt(new Date(System.currentTimeMillis())) //만든날짜
                .setExpiration(new Date(System.currentTimeMillis()+expireTimeMs)) //끝나는날짜 expiration date => expiry date 유통기한
                .signWith(SignatureAlgorithm.HS256,key) //HS256알고리즘을 이용해서 key를 암호화
                .compact();

    }
}
