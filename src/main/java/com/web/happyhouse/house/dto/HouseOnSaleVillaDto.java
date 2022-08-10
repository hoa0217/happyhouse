package com.web.happyhouse.house.dto;

import com.web.happyhouse.base.BaseDto;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.domain.HouseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * 매물(원룸, 투룸)Dto
 */
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleVillaDto extends BaseDto {

    private Long houseOnSaleVillaId;        // 거래ID
    private String dongCode;                // 법정동코드
    private String zoneCode;                // 우편번호
    private String jibunAddress;            // 도로명주소
    private HouseType houseType;            // 유형
    private double contractArea;            // 계약면적
    private double netLeasableArea;         // 전용면적
    private String totalFloor;              // 총층
    private String floor;                   // 해당층
    private String roomCount;               // 방수
    private String bathCount;               // 욕실수
    private DirType dirType;                // 방
    private String parkCount;               // 추차대수
    private String movingDate;              // 입주가능일
    private DealType dealType;              // 거래유형(매매, 전세, 월세)
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)
    private BigDecimal rent;                // 월세
    private BigDecimal mngFee;              // 관리비
}
