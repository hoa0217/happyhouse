package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaListDto {
    String zoneCode;                                                    // 우편번호
    HouseType houseType;                                                // 집유형
    List<HouseOnSaleVillaDto> houseOnSaleVillaMAEMAEList;               // 매매 매물 리스트
    List<HouseOnSaleVillaDto> houseOnSaleVillaJEONSEList;               // 매물 전세 리스트
    List<HouseOnSaleVillaDto> houseOnSaleVillaWOLSELList;               // 매물 월세 리스트
}
