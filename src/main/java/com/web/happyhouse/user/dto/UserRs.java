package com.web.happyhouse.user.dto;

import com.web.happyhouse.base.BaseDto;
import com.web.happyhouse.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel("회원 응답 정보")
@Getter
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


    @ApiModelProperty(notes = "사용자 역할(일반 사용자, 부동산 중개인)", example = "ROLE_USER", allowableValues = "ROLE_USER, ROLE_AGENT")
    private List<String> roles;

    public UserRs(User user){
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.roles = user.getRoles();
        this.setCreatedTime(user.getCreatedTime());
        this.setUpdatedTime(user.getUpdatedTime());
    }
}
