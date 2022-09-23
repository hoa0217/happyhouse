package com.web.happyhouse.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseDto {
    @ApiModelProperty(value = "생성 시간")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "수정 시간")
    private LocalDateTime updatedTime;
}
