package com.web.happyhouse.address.dto;

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
    private String gugunCode;        // 구군 코드
    private String sidoCode;         // 시도 코드
    private String gugunName;        // 구군 이름
}
