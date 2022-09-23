package com.web.happyhouse.house.dto.updateRequest;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("아파트,오피스텔 매물 Update 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleUpdateRq {

    @NotNull
    @ApiModelProperty(value = "매물ID", example = "1")
    private Long houseOnSaleId;             // 매물ID

    @ApiModelProperty(value = "계약면적")
    private double contractArea;            // 계약면적

    @ApiModelProperty(value = "전용면적")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(value = "총층")
    private String totalFloor;              // 총층

    @ApiModelProperty(value = "해당층")
    private String floor;                   // 해당층

    @ApiModelProperty(value = "방수")
    private String roomCount;               // 방수

    @ApiModelProperty(value = "욕실수")
    private String bathCount;               // 욕실수

    @ApiModelProperty(value = "방향", allowableValues = "EAST, WEST, NORTH, SOUTH, SOUTHEAST, NORTHEAST, SOUTHWEST, NORTHWEST")
    @Enumerated(EnumType.STRING)
    private DirType dirType;                // 방향

    @ApiModelProperty(value = "추차대수")
    private String parkCount;               // 추차대수

    @ApiModelProperty(value = "입주가능일")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래유형(매매, 전세, 월세)", allowableValues = "MAEMAE, JEONSE, WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;              // 거래유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비")
    private BigDecimal mngFee;              // 관리비

    @NotNull
    @ApiModelProperty(value = "옵션ID", example = "1")
    private Long houseOptionId;

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
