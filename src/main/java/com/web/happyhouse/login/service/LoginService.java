package com.web.happyhouse.login.service;

import com.web.happyhouse.user.dto.UserDto;

public interface LoginService {

    /**
     * 로그인
     * @param email
     * @param password
     * @return
     */
    UserDto login(String email, String password);

}
