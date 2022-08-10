package com.web.happyhouse.house.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleDetailDto {
    // 집정보
    HouseInfoDto houseInfoDto;

    // 집거래내역
    List<HouseDealDto> houseDealMAEMAEList;
    List<HouseDealDto> houseDealJEONSEList;
    List<HouseDealDto> houseDealWOLSEList;

    // 매물정보
    HouseOnSaleDto houseOnSaleDto;
    HouseOptionDto houseOptionDto;
}
