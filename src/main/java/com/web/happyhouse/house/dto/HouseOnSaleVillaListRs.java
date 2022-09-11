package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@ApiModel("빌라 매물 리스트 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaListRs {
    @ApiModelProperty(notes = "우편번호")
    String zoneCode;                                                    // 우편번호
    @ApiModelProperty(notes = "집유형")
    HouseType houseType;                                                // 집유형
    @ApiModelProperty(notes = "매매 매물 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaMAEMAEList;               // 매매 매물 리스트
    @ApiModelProperty(notes = "매물 전세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaJEONSEList;               // 매물 전세 리스트
    @ApiModelProperty(notes = "매물 월세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaWOLSELList;               // 매물 월세 리스트
}
