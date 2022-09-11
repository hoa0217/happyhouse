package com.web.happyhouse.login.contorller;

import com.web.happyhouse.login.dto.JoinRq;
import com.web.happyhouse.login.dto.LoginRq;
import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"로그인 Controller"})
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @ApiOperation(value = "User 로그인", notes="User 로그인하기(이메일, 비밀번호)")
    @GetMapping("/login")
    public ResponseDto<String> login(
            @ApiParam(value = "로그인 요청 form", required = true)
            @Valid @RequestBody LoginRq loginRq)
    {
        return ResponseDto.res(ResponseCode.OK, "로그인 성공", loginService.login(loginRq));
    }

    @ApiOperation(value = "User 가입", notes="User 가입하기")
    @PostMapping("/join")
    public ResponseDto<Long> join(
            @ApiParam(value = "가입 요청 form", required = true)
            @Valid @RequestBody JoinRq joinRq){
        return ResponseDto.res(ResponseCode.CREATED, "회원가입 성공", loginService.join(joinRq));
    }

}
