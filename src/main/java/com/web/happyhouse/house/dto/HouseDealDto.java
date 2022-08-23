package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.entity.HouseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@ApiModel("집 거래 정보")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HouseDealDto {
    @ApiModelProperty(notes = "집거래 ID", example = "1")
    private Long houseDealId;           // 거래ID
    @ApiModelProperty(notes = "면적", example = "33.04")
    private double area;                // 면적
    @ApiModelProperty(notes = "가격(매매가, 전세가, 월세보증금)")
    private BigDecimal price;           // 가격(매매가, 전세가, 월세보증금)
    @ApiModelProperty(notes = "월세")
    private BigDecimal rent;            // 월세
    @ApiModelProperty(notes = "거래년")
    private String dealYear;            // 거래년
    @ApiModelProperty(notes = "거래월")
    private String dealMonth;           // 거래월
    @ApiModelProperty(notes = "거래날짜")
    private String dealDay;             // 거래날짜
    @ApiModelProperty(notes = "층")
    private String floor;               // 충

    @ApiModelProperty(notes = "거래유형 (매매, 전세, 월세)", example = "WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;          // 거래유형(매매, 전세, 월세)

    @ApiModelProperty(notes = "집 정보 ID", example = "3")
    private Long houseInfoId;
}
