package com.web.happyhouse.login.service.implementation;

import com.web.happyhouse.advice.exception.DuplicatedUserException;
import com.web.happyhouse.advice.exception.EmailLoginFailedException;
import com.web.happyhouse.config.security.TokenProvider;
import com.web.happyhouse.login.dto.JoinRq;
import com.web.happyhouse.login.dto.LoginRq;
import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.user.entity.User;
import com.web.happyhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Override
    public String login(LoginRq loginRq) {
        // 회원 정보 존재하는지 확인
        User user = userRepository.findByEmail(loginRq.getEmail()).orElseThrow(() -> {
            throw new EmailLoginFailedException("이메일 또는 비밀번호가 맞지 않습니다.");
        });

        // 회원 패스워드 일치 여부 확인
        if(!passwordEncoder.matches(loginRq.getPassword(), user.getPassword())){
            throw new EmailLoginFailedException("이메일 또는 비밀번호가 맞지 않습니다.");
        }

        return tokenProvider.createTokenDto(user.getUserId(), user.getRoles());
    }

    @Override
    @Transactional
    public Long join(JoinRq joinRq) {

        if(userRepository.existsByEmail(joinRq.getEmail())){
            throw new DuplicatedUserException("이미 가입되어 있는 유저입니다.");
        }

        return userRepository.save(joinRq.toEntity(passwordEncoder)).getUserId();
    }
}
