package com.web.happyhouse.user.controller;

import com.web.happyhouse.config.security.TokenProvider;
import com.web.happyhouse.login.dto.LoginRq;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"User 관리 Controller"})
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "현재 로그인된 User 조회 (인증정보)", notes="인증정보로 User 조회하기")
    @GetMapping("/user")
    public ResponseDto<UserRs> getMyUserInfo() {
        return ResponseDto.res(ResponseCode.OK, "회원조회 성공", userService.getMyUserWithAuthorities());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 조회 (아이디)", notes="userId로 User 조회하기")
    @GetMapping("/user/id/{userId}")
    public ResponseDto<UserRs> get(@PathVariable("userId") Long userId){
        return ResponseDto.res(ResponseCode.OK, "회원조회 성공", userService.getById(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 조회 (이메일)", notes="email로 User 조회하기")
    @GetMapping("/user/email/{email}")
    public ResponseDto<UserRs> get(@PathVariable("email") String email){
        return ResponseDto.res(ResponseCode.OK, "회원조회 성공", userService.getByEmail(email));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 정보수정", notes="User 정보수정하기(이름)")
    @PatchMapping("/user")
    public ResponseDto<Long> update(@RequestParam("userId") Long userId,
                                    @RequestParam("name") String name) {
        Long updateId = userService.update(userId, name);
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트 성공", updateId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 탈퇴", notes="User 탈퇴하기")
    @DeleteMapping("/user")
    public ResponseDto delete(@Valid @RequestBody LoginRq loginRq) {
        userService.delete(loginRq.getEmail(), loginRq.getPassword());
        return ResponseDto.res(ResponseCode.OK, "회원탈퇴 완료");
    }

}
