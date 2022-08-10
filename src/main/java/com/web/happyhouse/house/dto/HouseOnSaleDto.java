package com.web.happyhouse.house.dto;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.entity.HouseInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleDto {

    private Long houseOnSaleId;             // 거래ID
    private String dongCode;                // 주소코드
    private double contractArea;            // 계약면적
    private double netLeasableArea;         // 전용면적
    private String totalFloor;              // 총층
    private String floor;                   // 해당층
    private String roomCount;               // 방수
    private String bathCount;               // 욕실수

    @Enumerated(EnumType.STRING)
    private DirType dirType;                // 방

    private String parkCount;               // 추차대수
    private String movingDate;              // 입주가능일

    @Enumerated(EnumType.STRING)
    private DealType dealType;              // 거래유형(매매, 전세, 월세)

    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)
    private BigDecimal rent;                // 월세
    private BigDecimal mngFee;              // 관리비
    private Long houseInfoId;            // 정보ID
}
