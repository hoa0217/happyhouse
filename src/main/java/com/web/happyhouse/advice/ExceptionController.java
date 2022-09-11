package com.web.happyhouse.advice;

import com.web.happyhouse.advice.exception.AccessDeniedException;
import com.web.happyhouse.advice.exception.AuthenticationEntryPointException;
import com.web.happyhouse.network.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/entryPoint")
    public ResponseDto entrypointException() {
        throw new AuthenticationEntryPointException("잘못된 접근입니다.");
    }

    @GetMapping("/accessDenied")
    public ResponseDto accessDeniedException() {
        throw new AccessDeniedException("권한이 없습니다.");
    }

}
