package com.web.happyhouse.user.controller;

import com.web.happyhouse.login.dto.LoginForm;
import com.web.happyhouse.login.session.SessionConst;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserDto;
import com.web.happyhouse.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"User 관리 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "로그인한 User 조회", notes="로그인한 User 조회하기")
    @GetMapping("/get")
    public ResponseDto<UserDto> get(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserDto user){
        // 세션에 회원 데이터가 없으면
        if (user == null) {
            return ResponseDto.res(ResponseCode.OK,"GUEST");
        }

        // 세션이 유지되면
        return ResponseDto.res(ResponseCode.OK,"USER", user);
    }

    @ApiOperation(value = "User 가입", notes="User 가입하기")
    @PostMapping("/join")
    public ResponseDto join(@Valid @ModelAttribute("userDto")UserDto userDto){
        userService.join(userDto);
        return ResponseDto.res(ResponseCode.CREATED, "회원가입 성공");
    }

    @ApiOperation(value = "User 정보수정", notes="User 정보수정하기(이름, 비밀번호)")
    @PatchMapping("/update")
    public ResponseDto<UserDto> update(@Valid @ModelAttribute("userDto")UserDto userDto) {
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트 성공", userService.update(userDto));
    }

    @ApiOperation(value = "User 탈퇴", notes="User 탈퇴하기")
    @DeleteMapping("/delete")
    public ResponseDto delete(@Valid @ModelAttribute("loginForm")LoginForm loginForm) {
        userService.delete(loginForm.getEmail(), loginForm.getPassword());
        return ResponseDto.res(ResponseCode.OK, "회원탈퇴 완료");
    }

}
