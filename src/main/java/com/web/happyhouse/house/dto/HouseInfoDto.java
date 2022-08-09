package com.web.happyhouse.house.dto;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.entity.HouseInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class HouseInfoDto {

    private Long houseInfoId;           // 정보ID
    private String dongCode;         // 주소코드
    private String beon;                // 번
    private String ji;                  // 지
    private String houseName;           // 건물명
    private String buildYear;           // 건축년도
    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 유형

}