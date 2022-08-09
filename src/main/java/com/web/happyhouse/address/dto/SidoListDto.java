package com.web.happyhouse.address.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 시도 List Dto
 */
@Getter
@Setter
@NoArgsConstructor
public class SidoListDto {
    List<SidoDto> sidoDtoList;
}
