package com.web.happyhouse.user.service.implementation;

import com.web.happyhouse.advice.exception.EmailLoginFailedException;
import com.web.happyhouse.advice.exception.NotFoundUserException;
import com.web.happyhouse.user.dto.UserRs;
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
        String username = SecurityUtil.getCurrentUsername().get();
        return this.getById(Long.parseLong(username));
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
    public Long update(Long userId, String name) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundUserException("해당 아이디(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        user.updateName(name);

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
}
