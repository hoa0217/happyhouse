package com.web.happyhouse.house.dto;

import com.web.happyhouse.base.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel("아파트,오피스텔 매물 옵션 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOptionDto extends BaseDto {
    @ApiModelProperty(value = "옵션ID", example = "1")
    private Long houseOptionId;

    @ApiModelProperty(value = "매물ID", example = "1")
    private Long houseOnSaleId;

    @ApiModelProperty(value = "전기포함유무")
    private Boolean electricYn;

    @ApiModelProperty(value = "가스포함유무")
    private Boolean gasYn;

    @ApiModelProperty(value = "수도포함유무")
    private Boolean waterYn;

    @ApiModelProperty(value = "인터넷포함유무")
    private Boolean internetYn;

    @ApiModelProperty(value = "TV연결포함유무")
    private Boolean tvConnectYn;

    @ApiModelProperty(value = "개인난방")
    private Boolean personalBoilYn;

    @ApiModelProperty(value = "중앙난방")
    private Boolean centerBoilYn;

    @ApiModelProperty(value = "지역난방")
    private Boolean localBoilYn;

    @ApiModelProperty(value = "냉장고유무")
    private Boolean rfgYn;

    @ApiModelProperty(value = "침대유무")
    private Boolean bedYn;

    @ApiModelProperty(value = "세탁기유무")
    private Boolean laundryYn;

    @ApiModelProperty(value = "에어컨유무")
    private Boolean airConditionerYn;

    @ApiModelProperty(value = "전자레인지유무")
    private Boolean microwaveYn;

    @ApiModelProperty(value = "가스레인지유무")
    private Boolean gasStoveYn;

    @ApiModelProperty(value = "인덕션유무")
    private Boolean inductionYn;

    @ApiModelProperty(value = "옷장유무")
    private Boolean closetYn;

    @ApiModelProperty(value = "TV유무")
    private Boolean tvYn;

    @ApiModelProperty(value = "승강기유무")
    private Boolean elevatorYn;
}
