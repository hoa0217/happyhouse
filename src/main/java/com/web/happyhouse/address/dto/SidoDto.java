package com.web.happyhouse.address.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 시도 Dto
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SidoDto {
    @ApiModelProperty(value = "시 코드")
    private String sidoCode;        // 시 코드

    @ApiModelProperty(value = "시 이름")
    private String sidoName;        // 시 이름
}
