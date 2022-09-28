package com.web.happyhouse.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ApiModel("회원 비밀번호 업데이트 정보")
public class UserUpdatePasswordRq {

    @ApiModelProperty(value = "현재 비밀번호", required = true)
    @NotEmpty
    private String pastPassword; // 현재 비밀번호

    @ApiModelProperty(value = "새 비밀번호", required = true)
    @NotEmpty
    private String newPassword; // 비밀번호


}
