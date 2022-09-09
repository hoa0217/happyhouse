package com.web.happyhouse.login.service.implementation;

import com.web.happyhouse.exception.NotFoundUserException;
import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.entity.User;
import com.web.happyhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public UserRs login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundUserException("이메일 또는 비밀번호가 맞지 않습니다.");
        });

        if(user.getPassword().equals(password)){
            throw new NotFoundUserException("이메일 또는 비밀번호가 맞지 않습니다.");
        }

        return User.toDto(user);
    }
}
