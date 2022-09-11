package com.web.happyhouse.login.service;

import com.web.happyhouse.login.dto.JoinRq;
import com.web.happyhouse.login.dto.LoginRq;

public interface LoginService {

    /**
     * 로그인
     * @param loginRq
     * @return
     */
    String login(LoginRq loginRq);

    /**
     * 회원가입
     * @param joinRq
     * @return
     */
    Long join(JoinRq joinRq);

}
