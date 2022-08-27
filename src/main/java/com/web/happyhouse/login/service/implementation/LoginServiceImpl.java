package com.web.happyhouse.login.service.implementation;

import com.web.happyhouse.login.service.LoginService;
import com.web.happyhouse.user.dto.UserDto;
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
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지 않습니다.");
        });

        if(user.getPassword().equals(password)){
            throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지 않습니다.");
        }

        return User.toDto(user);
    }
}
