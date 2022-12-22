package com.example.project.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class MyException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;


    @AllArgsConstructor
    @Getter
    public enum ErrorCode {
        DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"DUPLICATED메세지 테스트"),
        USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND,"Not founded메세지 테스트"),
        INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "INVALID_PASSWORD메세지 테스트");

        private HttpStatus httpStatus;
        private String message;
        //    1. DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "UserName이 중복됩니다.")
        //2. USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND,"Not founded")
        //3. INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "패스워드가 잘못되었습니다.")
        //4. INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다.")
        //5. INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "사용자가 권한이 없습니다.")
        //6. POST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 포스트가 없습니다.")
        //7. DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB에러")
    }
}