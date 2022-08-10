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
public class HouseOnSaleVillaMapDto {
    String dongCode;                                                    // 법정 동코드
    HouseType houseType;                                                // 집유형
    Map<String, Long> zoneCodeToCountingMap;                            // 맵에 띄울 정보
}
