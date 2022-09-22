package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.dto.HouseDealDto;
import com.web.happyhouse.house.dto.HouseInfoDto;
import com.web.happyhouse.house.dto.HouseOnSaleDto;
import com.web.happyhouse.house.dto.HouseOptionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    List<HouseDealDto> houseDealMAEMAEList = new ArrayList<>();
    @ApiModelProperty(notes = "집 거래 내역리스트 (전세)")
    List<HouseDealDto> houseDealJEONSEList = new ArrayList<>();
    @ApiModelProperty(notes = "집 거래 내역리스트 (월세)")
    List<HouseDealDto> houseDealWOLSEList = new ArrayList<>();

    // 매물정보
    @ApiModelProperty(notes = "집 매물")
    HouseOnSaleDto houseOnSaleDto;
    @ApiModelProperty(notes = "집 옵션")
    HouseOptionDto houseOptionDto;
}
