package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.base.BaseTimeEntity;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseOnSaleVillaDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * 매물(원룸, 투룸)Entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseOnSaleVilla extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "house_on_sale_villa_id")
    private Long houseOnSaleVillaId;             // 거래ID

    @ManyToOne(fetch = FetchType.LAZY)
    private Dong dong;                      // 법정동코드

    private String jibunAddress;            // 지번주소

    @Enumerated(EnumType.STRING)
    private HouseType houseType;            // 건물 유형

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
    private DealType dealType;              // 거래 유형(매매, 전세, 월세)

    @Column(scale = 0)
    private BigDecimal price;                     // 가격(매매가, 전세가, 월세보증금)

    @Column(scale = 0)
    private BigDecimal rent;                      // 월세

    @Column(scale = 0)
    private BigDecimal mngFee;                    // 관리비

    @Builder
    public HouseOnSaleVilla(Long houseOnSaleVillaId, Dong dong, String jibunAddress, HouseType houseType, double contractArea, double netLeasableArea, String totalFloor, String floor, String roomCount, String bathCount, DirType dirType, String parkCount, String movingDate, DealType dealType, BigDecimal price, BigDecimal rent, BigDecimal mngFee) {
        this.houseOnSaleVillaId = houseOnSaleVillaId;
        this.dong = dong;
        this.jibunAddress = jibunAddress;
        this.houseType = houseType;
        this.contractArea = contractArea;
        this.netLeasableArea = netLeasableArea;
        this.totalFloor = totalFloor;
        this.floor = floor;
        this.roomCount = roomCount;
        this.bathCount = bathCount;
        this.dirType = dirType;
        this.parkCount = parkCount;
        this.movingDate = movingDate;
        this.dealType = dealType;
        this.price = price;
        this.rent = rent;
        this.mngFee = mngFee;
    }

    public static HouseOnSaleVillaDto toDto(HouseOnSaleVilla entity) {
        HouseOnSaleVillaDto dto = new HouseOnSaleVillaDto();
        dto.setHouseOnSaleVillaId(entity.getHouseOnSaleVillaId());
        dto.setDongCode(entity.getDong().getDongCode());
        dto.setHouseType(entity.getHouseType());
        dto.setJibunAddress(entity.getJibunAddress());
        dto.setContractArea(entity.getContractArea());
        dto.setNetLeasableArea(entity.getNetLeasableArea());
        dto.setTotalFloor(entity.getTotalFloor());
        dto.setFloor(entity.getFloor());
        dto.setRoomCount(entity.getRoomCount());
        dto.setBathCount(entity.getBathCount());
        dto.setDirType(entity.getDirType());
        dto.setParkCount(entity.getParkCount());
        dto.setMovingDate(entity.getMovingDate());
        dto.setDealType(entity.getDealType());
        dto.setPrice(entity.getPrice());
        dto.setRent(entity.getRent());
        dto.setMngFee(entity.getMngFee());

        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public static HouseOnSaleVilla toEntity(HouseOnSaleVillaDto dto, Dong dong) {

        HouseOnSaleVilla entity = HouseOnSaleVilla.builder()
                .houseOnSaleVillaId(dto.getHouseOnSaleVillaId())
                .dong(dong)
                .jibunAddress(dto.getJibunAddress())
                .houseType(dto.getHouseType())
                .contractArea(dto.getContractArea())
                .netLeasableArea(dto.getNetLeasableArea())
                .totalFloor(dto.getTotalFloor())
                .floor(dto.getFloor())
                .roomCount(dto.getRoomCount())
                .bathCount(dto.getBathCount())
                .dirType(dto.getDirType())
                .parkCount(dto.getParkCount())
                .movingDate(dto.getMovingDate())
                .dealType(dto.getDealType())
                .price(dto.getPrice())
                .rent(dto.getRent())
                .mngFee(dto.getMngFee())
                .build();

        return entity;
    }
}
