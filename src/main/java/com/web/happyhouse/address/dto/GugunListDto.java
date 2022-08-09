package com.web.happyhouse.address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 구군 List Dto
 */
@Getter
@Setter
@NoArgsConstructor
public class GugunListDto {
    List<GugunDto> gugunDtoList;
}
