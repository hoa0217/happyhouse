package com.web.happyhouse.login.contorller;

import com.web.happyhouse.login.dto.LoginForm;
import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.login.session.SessionConst;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseDto login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest request){

        UserDto user = loginService.login(loginForm.getEmail(), loginForm.getPassword());

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);

        return ResponseDto.res(ResponseCode.OK, "로그인 성공");
    }

    @PostMapping("/logout")
    public ResponseDto logOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }

        return ResponseDto.res(ResponseCode.OK, "로그아웃 성공");
    }


}
