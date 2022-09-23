package com.web.happyhouse.login.contorller;

import com.web.happyhouse.login.dto.JoinRq;
import com.web.happyhouse.login.dto.LoginRq;
import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"로그인 Controller"})
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @ApiOperation(value = "User 로그인", notes="User 로그인하기(이메일, 비밀번호)")
    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 로그인을 성공했습니다."),
            @ApiResponse(code = 409, message = "CONFLICT 이메일 또는 비밀번호가 맞지 않습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<String> login(
            @ApiParam(value = "로그인 요청 form", required = true)
            @Valid @RequestBody LoginRq loginRq)
    {
        return ResponseDto.res(ResponseCode.OK, "로그인을 성공했습니다.", loginService.login(loginRq));
    }

    @ApiOperation(value = "User 가입", notes="User 가입하기")
    @PostMapping("/join")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED 회원가입을 완료했습니다."),
            @ApiResponse(code = 409, message = "CONFLICT 이미 가입되어 있는 유저입니다."),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto<Long> join(
            @ApiParam(value = "가입 요청 form", required = true)
            @Valid @RequestBody JoinRq joinRq){
        return ResponseDto.res(ResponseCode.CREATED, "회원가입을 완료했습니다.", loginService.join(joinRq));
    }
}
