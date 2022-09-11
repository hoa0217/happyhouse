package com.web.happyhouse.house.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@ApiModel("집 매물 리스트")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleListRs {
    @ApiModelProperty(notes = "집정보")
    HouseInfoDto houseInfoDto;                      // 집정보
    @ApiModelProperty(notes = "매매 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleMAEMAEList;     // 매매 매물 리스트
    @ApiModelProperty(notes = "전세 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleJEONSEList;     // 전세 매물 리스트
    @ApiModelProperty(notes = "월세 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleWOLSEList;      // 월세 매물 리스트
}
