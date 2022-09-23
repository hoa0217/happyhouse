package com.web.happyhouse.login.dto;

import com.web.happyhouse.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;

@ApiModel("가입 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
public class JoinRq {

    @NotEmpty
    @ApiModelProperty(value = "사용자 이메일", example = "gjwjdghk123@gmail.com", required = true)
    private String email; // 이메일

    @NotEmpty
    @ApiModelProperty(value = "사용자 이름", example = "허정화")
    private String name; // 이름

    @NotEmpty
    @ApiModelProperty(value = "비밀번호")
    private String password; // 비밀번호

    public User toEntity(PasswordEncoder passwordEncoder){
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
