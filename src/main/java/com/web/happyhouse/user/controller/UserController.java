package com.web.happyhouse.user.controller;

import com.web.happyhouse.login.dto.LoginForm;
import com.web.happyhouse.login.session.SessionConst;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserDto;
import com.web.happyhouse.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseDto<UserDto> get(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) UserDto user){
        // 세션에 회원 데이터가 없으면
        if (user == null) {
            return ResponseDto.res(ResponseCode.OK,"GUEST");
        }

        // 세션이 유지되면
        return ResponseDto.res(ResponseCode.OK,"USER", user);
    }

    @PostMapping("/join")
    public ResponseDto join(@Valid @ModelAttribute("userDto")UserDto userDto){
        userService.join(userDto);
        return ResponseDto.res(ResponseCode.CREATED, "회원가입 성공");
    }

    @PatchMapping("/update")
    public ResponseDto<UserDto> update(@Valid @ModelAttribute("userDto")UserDto userDto) {
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트 성공", userService.update(userDto));
    }

    @DeleteMapping("/delete")
    public ResponseDto delete(@Valid @ModelAttribute("loginForm")LoginForm loginForm) {
        userService.delete(loginForm.getEmail(), loginForm.getPassword());
        return ResponseDto.res(ResponseCode.OK, "회원탈퇴 완료");
    }

}
