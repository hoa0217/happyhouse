package com.web.happyhouse.house.dto.updateRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("아파트/오피스텔 옵션 Update 정보 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOptionUpdateDto {

    @NotNull
    @ApiModelProperty(notes = "옵션ID")
    private Long houseOptionId;

    @ApiModelProperty(notes = "전기포함유무")
    private Boolean electricYn;

    @ApiModelProperty(notes = "가스포함유무")
    private Boolean gasYn;

    @ApiModelProperty(notes = "수도포함유무")
    private Boolean waterYn;

    @ApiModelProperty(notes = "인터넷포함유무")
    private Boolean internetYn;

    @ApiModelProperty(notes = "TV연결포함유무")
    private Boolean tvConnectYn;

    @ApiModelProperty(notes = "개인난방")
    private Boolean personalBoilYn;

    @ApiModelProperty(notes = "중앙난방")
    private Boolean centerBoilYn;

    @ApiModelProperty(notes = "지역난방")
    private Boolean localBoilYn;

    @ApiModelProperty(notes = "냉장고유무")
    private Boolean rfgYn;

    @ApiModelProperty(notes = "침대유무")
    private Boolean bedYn;

    @ApiModelProperty(notes = "세탁기유무")
    private Boolean laundryYn;

    @ApiModelProperty(notes = "에어컨유무")
    private Boolean airConditionerYn;

    @ApiModelProperty(notes = "전자레인지유무")
    private Boolean microwaveYn;

    @ApiModelProperty(notes = "가스레인지유무")
    private Boolean gasStoveYn;

    @ApiModelProperty(notes = "인덕션유무")
    private Boolean inductionYn;

    @ApiModelProperty(notes = "옷장유무")
    private Boolean closetYn;

    @ApiModelProperty(notes = "TV유무")
    private Boolean tvYn;

    @ApiModelProperty(notes = "승강기유무")
    private Boolean elevatorYn;

}
