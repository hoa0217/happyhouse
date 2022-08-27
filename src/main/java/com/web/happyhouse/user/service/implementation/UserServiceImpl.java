package com.web.happyhouse.user.service.implementation;

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
    @Transactional
    public Long join(UserDto userDto) {

        User saveUser = userRepository.save(User.toEntity(userDto));

        return saveUser.getUserId();
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 ID(" + userId + ")의 회원을 찾을 수 없습니다.");
        });

        return User.toDto(user);
    }

    @Override
    @Transactional
    public Long update(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 이메일(" + userDto.getEmail() + ")의 회원을 찾을 수 없습니다.");
        });

        user.update(userDto.getName(), userDto.getPassword());

        return user.getUserId();
    }

    @Override
    @Transactional
    public void delete(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 이메일(" + email + ")의 회원을 찾을 수 없습니다.");
        });

        if(user.getPassword().equals(password)){
            userRepository.delete(user);
        }
        else{
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }
    }


}
