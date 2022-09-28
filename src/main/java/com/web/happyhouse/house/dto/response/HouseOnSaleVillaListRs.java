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
    @ApiModelProperty(value = "주소", example = "서울특별시 종로구 적선동 156")
    String jibunAddress;

    @ApiModelProperty(value = "건물 유형", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    HouseType houseType;

    @ApiModelProperty(value = "매매 매물 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaMAEMAEList = new ArrayList<>();

    @ApiModelProperty(value = "매물 전세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaJEONSEList = new ArrayList<>();

    @ApiModelProperty(value = "매물 월세 리스트")
    List<HouseOnSaleVillaDto> houseOnSaleVillaWOLSELList = new ArrayList<>();
}
