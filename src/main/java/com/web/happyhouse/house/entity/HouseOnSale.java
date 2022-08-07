package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 *  매물 Entity
 */
@Entity
@Getter
@Setter
public class HouseOnSale extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "house_on_sale_id")
    private Long houseOnSaleId;             // 거래ID

    @ManyToOne(fetch = FetchType.LAZY)
    private Dong dongCode;             // 주소코드

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

    @Column(scale = 0)
    private BigDecimal price;                     // 가격(매매가, 전세가, 월세보증금)

    @Column(scale = 0)
    private BigDecimal rent;                      // 월세

    @Column(scale = 0)
    private BigDecimal mngFee;                    // 관리비

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_info_id")
    private HouseInfo houseInfo;            // 정보ID

    @OneToOne(fetch = FetchType.LAZY)
    private HouseOption houseOption;        // 매물ID
}
