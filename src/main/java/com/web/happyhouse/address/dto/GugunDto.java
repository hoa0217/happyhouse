package com.web.happyhouse.address.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 구군Dto
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GugunDto {
    @ApiModelProperty(value = "구군 코드")
    private String gugunCode;        // 구군 코드

    @ApiModelProperty(value = "시도 코드")
    private String sidoCode;         // 시도 코드

    @ApiModelProperty(value = "구군 이름")
    private String gugunName;        // 구군 이름
}
