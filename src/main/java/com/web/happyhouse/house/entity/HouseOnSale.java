package com.web.happyhouse.house.entity;

import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.dto.HouseOnSaleDto;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateRq;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * 매물(아파트, 오피스텔) Entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseOnSale extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "house_on_sale_id")
    private Long houseOnSaleId;                 // 거래ID

    private double contractArea;                // 계약면적

    private double netLeasableArea;             // 전용면적

    private String totalFloor;                  // 총층

    private String floor;                       // 해당층

    private String roomCount;                   // 방수

    private String bathCount;                   // 욕실수

    @Enumerated(EnumType.STRING)
    private DirType dirType;                    // 방

    private String parkCount;                   // 추차대수

    private String movingDate;                  // 입주가능일

    @Enumerated(EnumType.STRING)
    private DealType dealType;                  // 거래유형(매매, 전세, 월세)

    @Column(scale = 0)
    private BigDecimal price;                   // 가격(매매가, 전세가, 월세보증금)

    @Column(scale = 0)
    private BigDecimal rent;                    // 월세

    @Column(scale = 0)
    private BigDecimal mngFee;                  // 관리비

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_info_id")
    private HouseInfo houseInfo;                // 정보

    @Builder
    private HouseOnSale(Long houseOnSaleId, double contractArea, double netLeasableArea, String totalFloor, String floor, String roomCount, String bathCount, DirType dirType, String parkCount, String movingDate, DealType dealType, BigDecimal price, BigDecimal rent, BigDecimal mngFee, HouseInfo houseInfo) {
        this.houseOnSaleId = houseOnSaleId;
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
        this.houseInfo = houseInfo;
    }


    public static HouseOnSaleDto toDto(HouseOnSale entity) {
        HouseOnSaleDto dto = new HouseOnSaleDto();
        dto.setHouseOnSaleId(entity.getHouseOnSaleId());
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
        dto.setHouseInfoId(entity.getHouseInfo().getHouseInfoId());

        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public static HouseOnSale toEntity(HouseOnSaleDto dto, HouseInfo houseInfo) {

        HouseOnSale entity = HouseOnSale.builder()
                .houseOnSaleId(dto.getHouseOnSaleId())
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
                .houseInfo(houseInfo)
                .build();

        return entity;
    }

    public void update(HouseOnSaleUpdateRq dto){
        this.contractArea = dto.getContractArea();
        this.netLeasableArea = dto.getNetLeasableArea();
        this.totalFloor = dto.getTotalFloor();
        this.floor = dto.getFloor();
        this.roomCount = dto.getRoomCount();
        this.bathCount = dto.getBathCount();
        this.dirType = dto.getDirType();
        this.parkCount = dto.getParkCount();
        this.movingDate = dto.getMovingDate();
        this.dealType = dto.getDealType();
        this.price = dto.getPrice();
        this.rent = dto.getRent();
        this.mngFee = dto.getMngFee();
    }
}
