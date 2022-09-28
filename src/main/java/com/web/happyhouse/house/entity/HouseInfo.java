package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseInfoDto;
import lombok.*;

import javax.persistence.*;

/**
 *  House정보 Entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseInfo {

    @Id
    @GeneratedValue
    @Column(name = "house_info_id")
    private Long houseInfoId;           // 정보ID

    @ManyToOne(fetch = FetchType.LAZY)
    private Dong dong;                  // 주소코드

    private String jiBun;              // 지번

    private String jibunAddress;        // 지번주소

    private String houseName;           // 건물명

    private String buildYear;           // 건축년도

    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 건물 유형


    @Builder
    private HouseInfo(Long houseInfoId, Dong dong, String jiBun, String jibunAddress, String houseName, String buildYear, HouseType houseType) {
        this.houseInfoId = houseInfoId;
        this.dong = dong;
        this.jiBun = jiBun;
        this.jibunAddress = jibunAddress;
        this.houseName = houseName;
        this.buildYear = buildYear;
        this.houseType = houseType;
    }

    public static HouseInfoDto toDto(HouseInfo entity){
        HouseInfoDto dto = new HouseInfoDto();
        dto.setHouseInfoId(entity.getHouseInfoId());
        dto.setDongCode(entity.getDong().getDongCode());
        dto.setJiBun(entity.getJiBun());
        dto.setJibunAddress(entity.getJibunAddress());
        dto.setHouseName(entity.getHouseName());
        dto.setBuildYear(entity.getBuildYear());
        dto.setHouseType(entity.getHouseType());
        return dto;
    }

    public static HouseInfo toEntity(HouseInfoDto dto, Dong dong) {

        HouseInfo entity = HouseInfo.builder()
                .houseInfoId(dto.getHouseInfoId())
                .dong(dong)
                .jiBun(dto.getJiBun())
                .jibunAddress(dto.getJibunAddress())
                .houseName(dto.getHouseName())
                .buildYear(dto.getBuildYear())
                .houseType(dto.getHouseType())
                .build();

        return entity;
    }
}
