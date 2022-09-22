package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.dto.HouseInfoDto;
import com.web.happyhouse.house.dto.HouseOnSaleDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@ApiModel("집 매물 리스트")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleListRs {
    @ApiModelProperty(value = "집정보")
    HouseInfoDto houseInfoDto;                      // 집정보

    @ApiModelProperty(value = "매매 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleMAEMAEList = new ArrayList<>();     // 매매 매물 리스트
    @ApiModelProperty(value = "전세 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleJEONSEList = new ArrayList<>();     // 전세 매물 리스트
    @ApiModelProperty(value = "월세 매물 리스트")
    List<HouseOnSaleDto> houseOnSaleWOLSEList = new ArrayList<>();      // 월세 매물 리스트
}
