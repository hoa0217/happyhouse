package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel("집 정보 리스트")
@Getter
@Setter
@NoArgsConstructor
public class HouseInfoListRs {
    @ApiModelProperty(value = "동 코드", example = "1165010800")
    String dongCode;                        // 동코드

    @ApiModelProperty(value = "집 유형", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    HouseType houseType;                    // 집유형

    @ApiModelProperty(value = "집 정보 리스트")
    List<HouseInfoDto> houseInfoDtoList;    // 집정보 리스트
}
