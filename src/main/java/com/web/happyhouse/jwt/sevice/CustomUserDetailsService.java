package com.web.happyhouse.jwt.sevice;

import com.web.happyhouse.advice.exception.NotFoundUserException;
import com.web.happyhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userPk){
        return userRepository.findById(Long.parseLong(userPk))
                .orElseThrow(() -> {
                    throw new NotFoundUserException("해당 ID(" + userPk + ")의 회원을 찾을 수 없습니다.");
                });
    }
}
