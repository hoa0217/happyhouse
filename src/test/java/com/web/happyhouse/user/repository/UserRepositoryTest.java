package com.web.happyhouse.user.repository;

import com.web.happyhouse.login.dto.JoinRq;
import com.web.happyhouse.user.dto.UserRq;
import com.web.happyhouse.user.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void 회원가입() throws Exception{
        // given
        JoinRq joinRq = new JoinRq();
        joinRq.setEmail("gjwjdghk123@naver.com");
        joinRq.setPassword("123123");
        joinRq.setName("안녕안녕나는정화야");
        User savedUser = userRepository.save(joinRq.toEntity(passwordEncoder));

        // when
        User repoUser = userRepository.findByEmail("gjwjdghk123@naver.com").get();

        // then
        Assertions.assertEquals(savedUser, repoUser);
    }

}