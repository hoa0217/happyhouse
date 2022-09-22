package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseOnSaleVillaDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel("빌라 매물 리스트 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaListRs {
    @ApiModelProperty(notes = "주소")
    String jibunAddress;

    @ApiModelProperty(notes = "집유형")
    HouseType houseType;

    @ApiModelProperty(notes = "매매 매물 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaMAEMAEList = new ArrayList<>();

    @ApiModelProperty(notes = "매물 전세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaJEONSEList = new ArrayList<>();

    @ApiModelProperty(notes = "매물 월세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaWOLSELList = new ArrayList<>();
}
