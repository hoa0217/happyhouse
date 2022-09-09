package com.web.happyhouse.user.dto;

import com.web.happyhouse.base.BaseDto;
import com.web.happyhouse.user.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@ApiModel("회원 정보")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRs extends BaseDto {

    @ApiModelProperty(notes = "사용자 ID", example = "1", required = true)
    private Long userId; // 사용자ID

    @NotEmpty
    @ApiModelProperty(notes = "사용자 이메일", example = "gjwjdghk123@gmail.com", required = true)
    private String email; // 이메일

    @NotEmpty
    @ApiModelProperty(notes = "사용자 이름", example = "허정화")
    private String name; // 이름

    @NotEmpty
    @ApiModelProperty(notes = "비밀번호")
    private String password; // 비밀번호

    @ApiModelProperty(notes = "사용자 역할(일반 사용자, 부동산 중개인)", example = "ROLE_USER", allowableValues = "ROLE_USER, ROLE_AGENT")
    private Role role;

}
