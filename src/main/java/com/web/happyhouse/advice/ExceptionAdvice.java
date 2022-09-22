package com.web.happyhouse.advice;

import com.web.happyhouse.advice.exception.*;
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
        return ResponseDto.res(ResponseCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    /**
     * 집정보 찾기 실패 예외
     */
    @ExceptionHandler(NotFoundHouseInfoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDto notFoundHouseInfoException(HttpServletRequest request, NotFoundHouseInfoException e){
        return ResponseDto.res(ResponseCode.BAD_REQUEST, e.getMessage());
    }

    /**
     * 매물정보 찾기 실패 예외
     */
    @ExceptionHandler(NotFoundHouseOnSaleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDto notFoundHouseOnSaleException(HttpServletRequest request, NotFoundHouseOnSaleException e){
        return ResponseDto.res(ResponseCode.BAD_REQUEST, e.getMessage());
    }

    /**
     * 옵션정보 찾기 실패 예외
     */
    @ExceptionHandler(NotFoundHouseOptionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDto notFoundHouseOptionException(HttpServletRequest request, NotFoundHouseOptionException e){
        return ResponseDto.res(ResponseCode.BAD_REQUEST, e.getMessage());
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
    protected ResponseDto duplicatedUserException(HttpServletRequest request, DuplicatedUserException e){
        return ResponseDto.res(ResponseCode.CONFLICT, e.getMessage());
    }

    /**
     * 유효한 자격증명을 제공하지 않고 접근할 경우 예외 (JWT 정상X)
     */
    @ExceptionHandler(AuthenticationEntryPointException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ResponseDto authenticationEntryPointException(HttpServletRequest request, AuthenticationEntryPointException e){
        return ResponseDto.res(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 필요한 권한이 없이 접근하려 할 경우 예외
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected ResponseDto accessDeniedException(HttpServletRequest request, AccessDeniedException e){
        return ResponseDto.res(ResponseCode.FORBIDDEN, e.getMessage());
    }

    /**
     * 액세스 토큰 만료시 발생하는 예외
     */
    @ExceptionHandler(ExpiredAccessTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ResponseDto expiredAccessTokenException(HttpServletRequest request, ExpiredAccessTokenException e) {
        return ResponseDto.res(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

}
