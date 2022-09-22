package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@ApiModel("MAP용 빌라 매물 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaMapRs {
    @ApiModelProperty(value = "법정동코드", example = "1165010800")
    String dongCode;

    @ApiModelProperty(value = "집유형", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    HouseType houseType;

    @ApiModelProperty(value = "맵에 띄울 정보", example = "{서울특별시 종로구 적선동 156 : 2}")
    Map<String, Long> jibunAddressToCountingMap;
}
