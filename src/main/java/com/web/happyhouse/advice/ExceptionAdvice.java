package com.web.happyhouse.advice;

import com.web.happyhouse.advice.exception.DuplicatedUserException;
import com.web.happyhouse.advice.exception.EmailLoginFailedException;
import com.web.happyhouse.advice.exception.NotFoundUserException;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseDto defaultException(HttpServletRequest request, Exception e){
        return ResponseDto.res(ResponseCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * 유저 찾기 실패 예외
     */
    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDto notFoundUserException(HttpServletRequest request, NotFoundUserException e){
        return ResponseDto.res(ResponseCode.BAD_REQUEST, e.getMessage());
    }

    /**
     * 유저 이메일 로그인 실패 예외
     */
    @ExceptionHandler(EmailLoginFailedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseDto emailLoginFailedException(HttpServletRequest request, EmailLoginFailedException e){
        return ResponseDto.res(ResponseCode.CONFLICT, e.getMessage());
    }

    /**
     * 기 가입자 예외
     */
    @ExceptionHandler(DuplicatedUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseDto duplicatedUserException(HttpServletRequest request, NotFoundUserException e){
        return ResponseDto.res(ResponseCode.CONFLICT, e.getMessage());
    }



}
