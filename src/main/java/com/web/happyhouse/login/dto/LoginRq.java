package com.web.happyhouse.login.dto;

import com.web.happyhouse.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;

@ApiModel("로그인 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginRq {

    @ApiModelProperty(value = "사용자 이메일", example = "gjwjdghk123@gmail.com", required = true)
    @NotEmpty
    private String email;

    @ApiModelProperty(value = "비밀번호")
    @NotEmpty
    private String password;

    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
