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
@ApiModel("회원 이름 업데이트 정보")
public class UserUpdateNameRq {

    @ApiModelProperty(value = "사용자 이름", example = "허정화", required = true)
    @NotEmpty
    private String name; // 이름

}
