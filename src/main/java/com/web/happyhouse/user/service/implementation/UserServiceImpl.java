package com.web.happyhouse.user.service.implementation;

import com.web.happyhouse.advice.exception.EmailLoginFailedException;
import com.web.happyhouse.advice.exception.NotFoundUserException;
import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.dto.UserUpdateNameRq;
import com.web.happyhouse.user.dto.UserUpdatePasswordRq;
import com.web.happyhouse.user.entity.User;
import com.web.happyhouse.user.repository.UserRepository;
import com.web.happyhouse.user.service.UserService;
import com.web.happyhouse.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRs getMyUserWithAuthorities() {
        return new UserRs(getMyUser());
    }

    @Override
    public UserRs getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundUserException("해당 아이디(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        return new UserRs(user);
    }

    @Override
    public UserRs getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundUserException("해당 이메일(" + email + ")의 회원을 찾을 수 없습니다.");
        });

        return new UserRs(user);
    }

    @Override
    @Transactional
    public Long updatePassword(UserUpdatePasswordRq updateRq) {
        User user = getMyUser();

        // 회원 패스워드 일치 여부 확인
        if(passwordEncoder.matches(updateRq.getPastPassword(), user.getPassword())){
            user.updatePassword(passwordEncoder.encode(updateRq.getNewPassword()));
        }
        else{
            throw new EmailLoginFailedException("비밀번호가 맞지 않습니다.");
        }

        return user.getUserId();
    }

    @Override
    @Transactional
    public Long updateName(UserUpdateNameRq updateRq) {
        User user = getMyUser();

        user.updateName(updateRq.getName());

        return user.getUserId();
    }

    @Override
    @Transactional
    public void delete(String email, String password) {

        // 회원 정보 존재하는지 확인
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new EmailLoginFailedException("이메일 또는 비밀번호가 맞지 않습니다.");
        });

        // 회원 패스워드 일치 여부 확인
        if(passwordEncoder.matches(password, user.getPassword())){
            userRepository.delete(user);
        }
        else{
            throw new EmailLoginFailedException("이메일 또는 비밀번호가 맞지 않습니다.");
        }

    }

    /**
     * 현재 로그인한 유저 찾기
     * @return
     */
    private User getMyUser() {
        String username = SecurityUtil.getCurrentUsername().get();

        User user = userRepository.findById(Long.parseLong(username)).orElseThrow(() -> {
            throw new NotFoundUserException("해당 아이디(" + Long.parseLong(username) + ")의 회원을 찾을 수 없습니다.");
        });
        return user;
    }
}
