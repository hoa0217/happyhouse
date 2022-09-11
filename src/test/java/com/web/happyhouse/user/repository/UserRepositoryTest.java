package com.web.happyhouse.user.repository;

import com.web.happyhouse.user.dto.UserRq;
import com.web.happyhouse.user.entity.Role;
import com.web.happyhouse.user.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception{
        // given
        UserRq userRq = new UserRq();
        userRq.setEmail("gjwjdghk123@naver.com");
        userRq.setPassword("123123");
        userRq.setName("안녕안녕나는정화야");
        userRq.setRole(Role.USER);
        User savedUser = userRepository.save(User.toEntity(userRq));

        // when
        User repoUser = userRepository.findByEmail("gjwjdghk123@naver.com").get();

        // then
        Assertions.assertEquals(savedUser, repoUser);
    }

}