package com.web.happyhouse.house.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaDetailDto {
    // 매물정보
    HouseOnSaleVillaDto houseOnSaleVillaDto;
    HouseOptionVillaDto houseOptionVillaDto;
}
