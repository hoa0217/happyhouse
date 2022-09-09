package com.web.happyhouse.login.service;

import com.web.happyhouse.user.dto.UserRs;

public interface LoginService {

    /**
     * 로그인
     * @param email
     * @param password
     * @return
     */
    UserRs login(String email, String password);

}
