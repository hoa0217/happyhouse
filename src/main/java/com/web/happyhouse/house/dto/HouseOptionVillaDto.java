package com.web.happyhouse.house.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@ApiModel("빌라 옵션 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseOptionVillaDto {
    @ApiModelProperty(notes = "옵션ID")
    private Long houseOptionVillaId;             // 옵션ID
    @ApiModelProperty(notes = "빌라매물ID")
    private Long houseOnSaleVillaId;            // 빌라매물ID
    @ApiModelProperty(notes = "전기포함유무")
    private Boolean electricYn;             // 전기포함유무
    @ApiModelProperty(notes = "가스포함유무")
    private Boolean gasYn;                  // 가스포함유무
    @ApiModelProperty(notes = "수도포함유무")
    private Boolean waterYn;                // 수도포함유무
    @ApiModelProperty(notes = "인터넷포함유무")
    private Boolean internetYn;             // 인터넷포함유무
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
