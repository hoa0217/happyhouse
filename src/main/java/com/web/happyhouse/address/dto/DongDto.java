package com.web.happyhouse.address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 동 Dto
 */
@Getter
@Setter
@NoArgsConstructor
public class DongDto {
    private String dongCode;        // 동 코드
    private String sidoCode;        // 시도 코드
    private String gugunCode;       // 구군 코드
    private String dongName;        // 동 이름
}
