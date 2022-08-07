package com.web.happyhouse.house.entity;

import com.web.happyhouse.house.domain.DealType;
import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * House거래 Entity
 */
@Entity
@Getter
@Setter
public class HouseDeal {

    @Id @GeneratedValue
    private Long houseDealId;           // 거래ID

    private double area;                // 면적

    @Column(scale = 2)
    private BigDecimal price;           // 가격(매매가, 전세가, 월세보증금)

    @Column(scale = 2)
    private BigDecimal rent;            // 월세

    private String dealYear;            // 거래년

    private String dealMonth;           // 거래월

    private String dealDay;             // 거래날짜

    private String floor;               // 충

    @Enumerated(EnumType.STRING)
    private DealType dealType;            // 거래유형(매매, 전세, 월세)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_info_id")
    private HouseInfo houseInfo;

}
