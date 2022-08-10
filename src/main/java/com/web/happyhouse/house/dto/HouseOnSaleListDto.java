package com.web.happyhouse.house.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleListDto {
    HouseInfoDto houseInfoDto;                      // 집정보
    List<HouseOnSaleDto> houseOnSaleMAEMAEList;     // 매매 매물 리스트
    List<HouseOnSaleDto> houseOnSaleJEONSEList;     // 전세 매물 리스트
    List<HouseOnSaleDto> houseOnSaleWOLSEList;      // 월세 매물 리스트
}
