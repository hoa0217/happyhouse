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

    @ApiModelProperty(value = "법정동코드", example = "1165010800")
    private String dongCode;                // 법정동코드

    @ApiModelProperty(value = "도로명주소")
    private String jibunAddress;            // 도로명주소

    @ApiModelProperty(value = "유형", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    private HouseType houseType;            // 유형

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
    private DirType dirType;                // 방향

    @ApiModelProperty(value = "추차대수")
    private String parkCount;               // 추차대수

    @ApiModelProperty(value = "입주가능일")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래유형(매매, 전세, 월세)", allowableValues = "MAEMAE, JEONSE, WOLSE")
    private DealType dealType;              // 거래유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비")
    private BigDecimal mngFee;              // 관리비
}
