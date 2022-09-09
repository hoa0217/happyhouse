package com.web.happyhouse.user.service;

import com.web.happyhouse.user.dto.UserRs;

public interface UserService {

    /**
     * 회원 조회
     * @param userId
     * @return
     */
    UserRs get(Long userId);

    /**
     * 회원가입
     * @param userRs
     * @return
     */
    UserRs join(UserRs userRs);

    /**
     * 회원정보 수정
     * @param userRs
     * @return
     */
    UserRs update(UserRs userRs);

    /**
     * 탈퇴하기
     * @param email
     * @param password
     * @return
     */
    void delete(String email, String password);

}
