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
    @ApiModelProperty(notes = "거래ID")
    private Long houseOnSaleVillaId;        // 거래ID

    @ApiModelProperty(notes = "법정동코드")
    private String dongCode;                // 법정동코드

    @ApiModelProperty(notes = "도로명주소")
    private String jibunAddress;            // 도로명주소

    @ApiModelProperty(notes = "유형")
    private HouseType houseType;            // 유형

    @ApiModelProperty(notes = "계약면적")
    private double contractArea;            // 계약면적

    @ApiModelProperty(notes = "전용면적")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(notes = "총층")
    private String totalFloor;              // 총층

    @ApiModelProperty(notes = "해당층")
    private String floor;                   // 해당층

    @ApiModelProperty(notes = "방수")
    private String roomCount;               // 방수

    @ApiModelProperty(notes = "욕실수")
    private String bathCount;               // 욕실수

    @ApiModelProperty(notes = "방")
    private DirType dirType;                // 방

    @ApiModelProperty(notes = "추차대수")
    private String parkCount;               // 추차대수

    @ApiModelProperty(notes = "입주가능일")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(notes = "거래유형(매매, 전세, 월세)")
    private DealType dealType;              // 거래유형(매매, 전세, 월세)

    @ApiModelProperty(notes = "가격(매매가, 전세가, 월세보증금)")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(notes = "월세")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(notes = "관리비")
    private BigDecimal mngFee;              // 관리비
}
