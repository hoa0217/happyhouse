package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.dto.HouseOnSaleVillaDto;
import com.web.happyhouse.house.dto.HouseOptionVillaDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel("빌라 매물 상세정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaDetailRs {
    // 매물정보
    @ApiModelProperty(notes = "빌라 매물 정보")
    HouseOnSaleVillaDto houseOnSaleVillaDto;
    @ApiModelProperty(notes = "빌라 옵션 정보")
    HouseOptionVillaDto houseOptionVillaDto;
}
