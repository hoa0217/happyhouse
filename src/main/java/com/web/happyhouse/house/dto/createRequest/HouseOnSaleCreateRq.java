package com.web.happyhouse.house.dto.createRequest;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.entity.HouseInfo;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("아파트,오피스텔 매물 Create 요청 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleCreateRq {

    @NotNull
    @ApiModelProperty(value = "집정보ID", example = "1", required = true)
    Long houseInfoId;                       // 집정보ID

    @ApiModelProperty(value = "계약면적", example = "36.66")
    private double contractArea;            // 계약면적

    @ApiModelProperty(value = "전용면적", example = "25.22")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(value = "총층", example = "15")
    private String totalFloor;              // 총층

    @ApiModelProperty(value = "해당층", example = "10")
    private String floor;                   // 해당층

    @ApiModelProperty(value = "방수", example = "2")
    private String roomCount;               // 방수

    @ApiModelProperty(value = "욕실수", example = "1")
    private String bathCount;               // 욕실수

    @ApiModelProperty(value = "방향", example = "SOUTH", allowableValues = "EAST, WEST, NORTH, SOUTH, SOUTHEAST, NORTHEAST, SOUTHWEST, NORTHWEST")
    @Enumerated(EnumType.STRING)
    private DirType dirType;                // 방향

    @ApiModelProperty(value = "추차대수", example = "2")
    private String parkCount;               // 추차대수

    @ApiModelProperty(value = "입주가능일", example = "20230112")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래 유형(매매, 전세, 월세)", example = "MAEMAE", allowableValues = "MAEMAE, JEONSE, WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;              // 거래 유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)", example = "45000")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세", example = "50")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비", example = "10")
    private BigDecimal mngFee;              // 관리비

    public HouseOnSale toHouseOnSaleEntity(HouseInfo houseInfo){
        return HouseOnSale.builder()
                .houseInfo(houseInfo)
                .contractArea(contractArea)
                .netLeasableArea(netLeasableArea)
                .totalFloor(totalFloor)
                .floor(floor)
                .roomCount(roomCount)
                .bathCount(bathCount)
                .dirType(dirType)
                .parkCount(parkCount)
                .movingDate(movingDate)
                .dealType(dealType)
                .price(price)
                .rent(rent)
                .mngFee(mngFee)
                .build();
    }

    @ApiModelProperty(value = "전기포함유무")
    private Boolean electricYn;             // 전기포함유무

    @ApiModelProperty(value = "가스포함유무")
    private Boolean gasYn;                  // 가스포함유무

    @ApiModelProperty(value = "수도포함유무")
    private Boolean waterYn;                // 수도포함유무

    @ApiModelProperty(value = "인터넷포함유무")
    private Boolean internetYn;             // 인터넷포함유무

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

    public HouseOption toHouseOptionEntity(HouseOnSale houseOnSale){
        return HouseOption.builder()
                .houseOnSale(houseOnSale)
                .electricYn(electricYn)
                .gasYn(gasYn)
                .waterYn(waterYn)
                .internetYn(internetYn)
                .tvConnectYn(tvConnectYn)
                .personalBoilYn(personalBoilYn)
                .centerBoilYn(centerBoilYn)
                .localBoilYn(localBoilYn)
                .rfgYn(rfgYn)
                .bedYn(bedYn)
                .laundryYn(laundryYn)
                .airConditionerYn(airConditionerYn)
                .microwaveYn(microwaveYn)
                .gasStoveYn(gasStoveYn)
                .inductionYn(inductionYn)
                .closetYn(closetYn)
                .tvYn(tvYn)
                .elevatorYn(elevatorYn)
                .build();
    }

}
