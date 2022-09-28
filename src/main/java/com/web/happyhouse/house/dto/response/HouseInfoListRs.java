package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.address.dto.DongDto;
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
    @ApiModelProperty(value = "동 정보")
    DongDto dongDto;

    @ApiModelProperty(value = "집 정보 리스트")
    List<HouseInfoDto> houseInfoDtoList;    // 집정보 리스트
}
