package com.web.happyhouse.address.dto;

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
    private String sidoCode;        // 시 코드
    private String sidoName;        // 시 이름
}
