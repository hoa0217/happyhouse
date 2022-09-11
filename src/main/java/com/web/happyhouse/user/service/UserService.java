package com.web.happyhouse.user.service;

import com.web.happyhouse.user.dto.UserRq;
import com.web.happyhouse.user.dto.UserRs;

public interface UserService {

    /**
     * 회원 아이디 조회
     * @param userId
     * @return
     */
    UserRs getById(Long userId);

    /**
     * 회원 이메일 조회
     * @param email
     * @return
     */
    UserRs getByEmail(String email);

    /**
     * 회원정보 수정
     * @param userId
     * @param name
     * @return
     */
    Long update(Long userId, String name);

    /**
     * 탈퇴하기
     * @param email
     * @param password
     * @return
     */
    void delete(String email, String password);

}
