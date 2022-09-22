package com.web.happyhouse.house.dto.updateRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel("아파트/오피스텔 매물 Update 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleUpdateRq {

    @ApiModelProperty(notes = "매물 정보")
    HouseOnSaleUpdateDto houseOnSaleUpdateDto;

    @ApiModelProperty(notes = "옵션 정보")
    HouseOptionUpdateDto houseOptionUpdateDto;

}
