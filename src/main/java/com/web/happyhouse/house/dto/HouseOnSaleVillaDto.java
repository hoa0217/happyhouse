package com.web.happyhouse.house.dto;

import com.web.happyhouse.base.BaseDto;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@ApiModel("빌라(원룸, 투룸) 매물 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaDto extends BaseDto {
    @ApiModelProperty(value = "거래ID", example = "1")
    private Long houseOnSaleVillaId;        // 거래ID

    @ApiModelProperty(value = "법정동코드", example = "1111010400")
    private String dongCode;                // 법정동코드

    @ApiModelProperty(value = "지번주소", example = "서울특별시 노원구 상계동 348-6")
    private String jibunAddress;            // 지번주소

    @ApiModelProperty(value = "건물 유형", example = "ONEROOM", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    private HouseType houseType;            // 건물 유형

    @ApiModelProperty(value = "계약면적", example = "36.66")
    private double contractArea;            // 계약면적

    @ApiModelProperty(value = "전용면적", example = "25.22")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(value = "총층", example = "5")
    private String totalFloor;              // 총층

    @ApiModelProperty(value = "해당층", example = "3")
    private String floor;                   // 해당층

    @ApiModelProperty(value = "방수", example = "1")
    private String roomCount;               // 방수

    @ApiModelProperty(value = "욕실수", example = "1")
    private String bathCount;               // 욕실수

    @ApiModelProperty(value = "방향", example = "WEST", allowableValues = "EAST, WEST, NORTH, SOUTH, SOUTHEAST, NORTHEAST, SOUTHWEST, NORTHWEST")
    private DirType dirType;                // 방향

    @ApiModelProperty(value = "추차대수", example = "0")
    private String parkCount;               // 추차대수

    @ApiModelProperty(value = "입주가능일", example = "20221201")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래 유형(매매, 전세, 월세)", example = "JEONSE",allowableValues = "MAEMAE, JEONSE, WOLSE")
    private DealType dealType;              // 거래 유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)", example = "1000")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세", example = "50")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비", example = "8")
    private BigDecimal mngFee;              // 관리비
}
