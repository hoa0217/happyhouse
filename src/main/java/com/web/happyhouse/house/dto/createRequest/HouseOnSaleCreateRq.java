package com.web.happyhouse.house.dto.createRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@ApiModel("아파트/오피스텔 매물 Create 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleCreateRq {

    @NotNull
    @ApiModelProperty(notes = "정보ID", example = "1", required = true)
    Long houseInfoId;                       // 정보ID

    @ApiModelProperty(notes = "매물 정보")
    HouseOnSaleCreateDto houseOnSaleDto;

    @ApiModelProperty(notes = "옵션 정보")
    HouseOptionCreateDto houseOptionDto;

}
