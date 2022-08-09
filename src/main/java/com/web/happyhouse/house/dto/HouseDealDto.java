package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.entity.HouseInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class HouseDealDto {

    private Long houseDealId;           // 거래ID
    private double area;                // 면적
    private BigDecimal price;           // 가격(매매가, 전세가, 월세보증금)
    private BigDecimal rent;            // 월세
    private String dealYear;            // 거래년
    private String dealMonth;           // 거래월
    private String dealDay;             // 거래날짜
    private String floor;               // 충

    @Enumerated(EnumType.STRING)
    private DealType dealType;          // 거래유형(매매, 전세, 월세)

    private Long houseInfoId;
}
