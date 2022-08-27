package com.web.happyhouse.login.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@ApiModel("로그인폼")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginForm {

    @ApiModelProperty(notes = "사용자 이메일", example = "gjwjdghk123@gmail.com", required = true)
    @NotEmpty
    private String email;

    @ApiModelProperty(notes = "비밀번호")
    @NotEmpty
    private String password;

}
