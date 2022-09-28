package com.web.happyhouse.user.service;

import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.dto.UserUpdateNameRq;
import com.web.happyhouse.user.dto.UserUpdatePasswordRq;

public interface UserService {

    /**
     * 현재 로그인한 회원 조회
     * @return
     */
    UserRs getMyUserWithAuthorities();

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
     * 회원정보 비밀번호 수정
     * @param updateRq
     * @return
     */
    Long updatePassword(UserUpdatePasswordRq updateRq);

    /**
     * 회원정보 이름 수정
     * @param updateRq
     * @return
     */
    Long updateName(UserUpdateNameRq updateRq);

    /**
     * 탈퇴하기
     * @param email
     * @param password
     * @return
     */
    void delete(String email, String password);

}
