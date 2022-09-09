package com.web.happyhouse.user.controller;

import com.web.happyhouse.login.dto.LoginForm;
import com.web.happyhouse.login.session.SessionConst;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"User 관리 Controller"})
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "로그인한 User 조회", notes="로그인한 User 조회하기")
    @GetMapping("/user/get")
    public ResponseDto<UserRs> get(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserRs user){
        // 세션에 회원 데이터가 없으면
        if (user == null) {
            return ResponseDto.res(ResponseCode.OK,"GUEST");
        }

        // 세션이 유지되면
        return ResponseDto.res(ResponseCode.OK,"USER", user);
    }

    @ApiOperation(value = "User 조회", notes="User 조회하기")
    @GetMapping("/user/{userId}")
    public ResponseDto<UserRs> get(@PathVariable("userId") Long userId){
        return ResponseDto.res(ResponseCode.OK, "회원조회 성공", userService.get(userId));
    }

    @ApiOperation(value = "User 가입", notes="User 가입하기")
    @PostMapping("/user")
    public ResponseDto join(@Valid @ModelAttribute("userDto") UserRs userRs){
        userService.join(userRs);
        return ResponseDto.res(ResponseCode.CREATED, "회원가입 성공");
    }

    @ApiOperation(value = "User 정보수정", notes="User 정보수정하기(이름, 비밀번호)")
    @PatchMapping("/user/{userId}")
    public ResponseDto<UserRs> update(@Valid @ModelAttribute("userDto") UserRs userRs) {
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트 성공", userService.update(userRs));
    }

    @ApiOperation(value = "User 탈퇴", notes="User 탈퇴하기")
    @DeleteMapping("/user/{userId}")
    public ResponseDto delete(@Valid @ModelAttribute("loginForm")LoginForm loginForm) {
        userService.delete(loginForm.getEmail(), loginForm.getPassword());
        return ResponseDto.res(ResponseCode.OK, "회원탈퇴 완료");
    }

}
