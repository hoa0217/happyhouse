package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.HouseType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *  House정보 Entity
 */
@Entity
@Getter
@Setter
public class HouseInfo {

    @Id
    @GeneratedValue
    @Column(name = "house_info_id")
    private Long houseInfoId;           // 정보ID

    @ManyToOne(fetch = FetchType.LAZY)
    private Dong dongCode;         // 주소코드

    private String beon;                // 번

    private String ji;                  // 지

    private String houseName;           // 건물명

    private String buildYear;           // 건축년도

    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 유형

}
