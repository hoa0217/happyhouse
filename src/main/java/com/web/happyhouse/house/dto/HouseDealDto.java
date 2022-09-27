package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.DealType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@ApiModel("아파트,오피스텔 거래 DTO")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HouseDealDto {
    @ApiModelProperty(value = "집거래 ID", example = "0")
    private Long houseDealId;           // 거래ID
    @ApiModelProperty(value = "면적", example = "45.36")
    private double area;                // 면적
    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)", example = "27000")
    private BigDecimal price;           // 가격(매매가, 전세가, 월세보증금)
    @ApiModelProperty(value = "월세", example = "0")
    private BigDecimal rent;            // 월세
    @ApiModelProperty(value = "거래년", example = "2021")
    private String dealYear;            // 거래년
    @ApiModelProperty(value = "거래월", example = "6")
    private String dealMonth;           // 거래월
    @ApiModelProperty(value = "거래날짜", example = "14")
    private String dealDay;             // 거래날짜
    @ApiModelProperty(value = "층", example = "11")
    private String floor;               // 충

    @ApiModelProperty(value = "거래 유형 (매매, 전세, 월세)", example = "MAEMAE", allowableValues = "MAEMAE, JEONSE, WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;          // 거래 유형(매매, 전세, 월세)

    @ApiModelProperty(value = "집정보ID", example = "0")
    private Long houseInfoId;
}
