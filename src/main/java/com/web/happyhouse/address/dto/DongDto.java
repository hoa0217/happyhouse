package com.web.happyhouse.address.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 동 Dto
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DongDto {
    @ApiModelProperty(value = "동 코드", example = "1111010700")
    private String dongCode;        // 동 코드

    @ApiModelProperty(value = "시도 코드", example = "11")
    private String sidoCode;        // 시도 코드

    @ApiModelProperty(value = "구군 코드", example = "11110")
    private String gugunCode;       // 구군 코드

    @ApiModelProperty(value = "동 이름", example = "적선동")
    private String dongName;        // 동 이름
}
