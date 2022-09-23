package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.dto.HouseDealDto;
import com.web.happyhouse.house.dto.HouseInfoDto;
import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * House거래 Entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    private HouseDeal(Long houseDealId, double area, BigDecimal price, BigDecimal rent, String dealYear, String dealMonth, String dealDay, String floor, DealType dealType, HouseInfo houseInfo) {
        this.houseDealId = houseDealId;
        this.area = area;
        this.price = price;
        this.rent = rent;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.floor = floor;
        this.dealType = dealType;
        this.houseInfo = houseInfo;
    }

    public static HouseDealDto toDto(HouseDeal entity){
        HouseDealDto dto = new HouseDealDto();
        dto.setHouseDealId(entity.getHouseDealId());
        dto.setArea(entity.getArea());
        dto.setPrice(entity.getPrice());
        dto.setRent(entity.getRent());
        dto.setDealYear(entity.getDealYear());
        dto.setDealMonth(entity.getDealMonth());
        dto.setDealDay(entity.getDealDay());
        dto.setFloor(entity.getFloor());
        dto.setDealType(entity.getDealType());
        dto.setHouseInfoId(entity.getHouseInfo().getHouseInfoId());
        return dto;
    }
    public static HouseDeal toEntity(HouseDealDto dto, HouseInfo houseInfo) {

        HouseDeal entity = HouseDeal.builder()
                .houseDealId(dto.getHouseDealId())
                .area(dto.getArea())
                .price(dto.getPrice())
                .rent(dto.getRent())
                .dealYear(dto.getDealYear())
                .dealMonth(dto.getDealMonth())
                .dealDay(dto.getDealDay())
                .floor(dto.getFloor())
                .dealType(dto.getDealType())
                .houseInfo(houseInfo)
                .build();

        return entity;
    }

}
