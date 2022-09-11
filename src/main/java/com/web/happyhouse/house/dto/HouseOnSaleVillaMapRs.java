package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@ApiModel("MAP용 빌라 매물 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaMapRs {
    @ApiModelProperty(notes = "법정동코드")
    String dongCode;                                                    // 법정동코드
    @ApiModelProperty(notes = "집유형")
    HouseType houseType;                                                // 집유형
    @ApiModelProperty(notes = "맵에 띄울 정보")
    Map<String, Long> zoneCodeToCountingMap;                            // 맵에 띄울 정보
}
