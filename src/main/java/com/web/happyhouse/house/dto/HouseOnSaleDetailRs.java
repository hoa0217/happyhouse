package com.web.happyhouse.house.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel("집 매물 상세정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleDetailRs {
    // 집정보
    @ApiModelProperty(notes = "집 정보")
    HouseInfoDto houseInfoDto;

    // 집거래내역
    @ApiModelProperty(notes = "집 거래 내역리스트 (매매)")
    List<HouseDealDto> houseDealMAEMAEList;
    @ApiModelProperty(notes = "집 거래 내역리스트 (전세)")
    List<HouseDealDto> houseDealJEONSEList;
    @ApiModelProperty(notes = "집 거래 내역리스트 (월세)")
    List<HouseDealDto> houseDealWOLSEList;

    // 매물정보
    @ApiModelProperty(notes = "집 매물")
    HouseOnSaleDto houseOnSaleDto;
    @ApiModelProperty(notes = "집 옵션")
    HouseOptionDto houseOptionDto;
}
