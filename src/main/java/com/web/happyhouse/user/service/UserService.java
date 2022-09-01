package com.web.happyhouse.user.service;

import com.web.happyhouse.user.dto.UserDto;

public interface UserService {

    /**
     * 회원 조회
     * @param userId
     * @return
     */
    UserDto get(Long userId);

    /**
     * 회원가입
     * @param userDto
     * @return
     */
    UserDto join(UserDto userDto);

    /**
     * 회원정보 수정
     * @param userDto
     * @return
     */
    UserDto update(UserDto userDto);

    /**
     * 탈퇴하기
     * @param email
     * @param password
     * @return
     */
    void delete(String email, String password);

}