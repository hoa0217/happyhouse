package com.web.happyhouse.user.service.implementation;

import com.web.happyhouse.exception.DuplicatedUserException;
import com.web.happyhouse.exception.NotFoundUserException;
import com.web.happyhouse.user.dto.UserDto;
import com.web.happyhouse.user.entity.User;
import com.web.happyhouse.user.repository.UserRepository;
import com.web.happyhouse.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto get(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundUserException("해당 아이디(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        return User.toDto(user);
    }

    @Override
    @Transactional
    public UserDto join(UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new DuplicatedUserException("이미 가입되어 있는 유저입니다.");
        }

        User saveUser = userRepository.save(User.toEntity(userDto));

        return User.toDto(saveUser);
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElseThrow(() -> {
            throw new NotFoundUserException("해당 아이디(" + userDto.getUserId() + ")의 회원을 찾을 수 없습니다.");
        });

        user.update(userDto.getName(), userDto.getPassword());

        return User.toDto(user);
    }

    @Override
    @Transactional
    public void delete(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new NotFoundUserException("이메일 또는 비밀번호가 맞지 않습니다.");
        });

        if(user.getPassword().equals(password)){
            userRepository.delete(user);
        }
        else{
            throw new NotFoundUserException("이메일 또는 비밀번호가 맞지 않습니다.");
        }
    }
}