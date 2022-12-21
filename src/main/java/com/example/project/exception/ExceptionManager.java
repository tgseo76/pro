package com.example.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> myExHandler(MyException e){
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()) //409error
                .body(e.getErrorCode().name()+" + (myExHandler.body) + "+e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runTimeEx(RuntimeException e){
        return ResponseEntity.status(HttpStatus.CONFLICT) //409error
                .body(e.getMessage());
    }
}
//    1. DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "UserName이 중복됩니다.")  ---
//2. USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND,"Not founded")
//3. INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "패스워드가 잘못되었습니다.")
//4. INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다.")
//5. INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "사용자가 권한이 없습니다.")
//6. POST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 포스트가 없습니다.")
//7. DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB에러")