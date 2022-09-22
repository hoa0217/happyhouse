package com.web.happyhouse.house.entity;

import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.house.dto.HouseOptionVillaDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseOptionVilla extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "house_option_villa_id")
    private Long houseOptionVillaId;             // 옵션ID

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_on_sale_villa_id")
    private HouseOnSaleVilla houseOnSaleVilla;        // 빌라매물ID

    private Boolean electricYn;             // 전기세포함유무
    private Boolean gasYn;                  // 가스비포함유무
    private Boolean waterYn;                // 수도세포함유무
    private Boolean internetYn;             // 인터넷연결포함유무
    private Boolean tvConnectYn;            // TV연결포함유무

    private Boolean personalBoilYn;         // 개인난방
    private Boolean centerBoilYn;           // 중앙난방
    private Boolean localBoilYn;            // 지역난방

    private Boolean rfgYn;                  // 냉장고유무
    private Boolean bedYn;                  // 침대유무
    private Boolean laundryYn;              // 세탁기유무
    private Boolean airConditionerYn;       // 에어컨유무
    private Boolean microwaveYn;            // 전자레인지유무
    private Boolean gasStoveYn;             // 가스레인지유무
    private Boolean inductionYn;            // 인덕션유무
    private Boolean closetYn;               // 옷장유무

    private Boolean tvYn;                   // TV유무
    private Boolean elevatorYn;             // 승강기유무

    @Builder
    private HouseOptionVilla(Long houseOptionVillaId, HouseOnSaleVilla houseOnSaleVilla, Boolean electricYn, Boolean gasYn, Boolean waterYn, Boolean internetYn, Boolean tvConnectYn, Boolean personalBoilYn, Boolean centerBoilYn, Boolean localBoilYn, Boolean rfgYn, Boolean bedYn, Boolean laundryYn, Boolean airConditionerYn, Boolean microwaveYn, Boolean gasStoveYn, Boolean inductionYn, Boolean closetYn, Boolean tvYn, Boolean elevatorYn) {
        this.houseOptionVillaId = houseOptionVillaId;
        this.houseOnSaleVilla = houseOnSaleVilla;
        this.electricYn = electricYn;
        this.gasYn = gasYn;
        this.waterYn = waterYn;
        this.internetYn = internetYn;
        this.tvConnectYn = tvConnectYn;
        this.personalBoilYn = personalBoilYn;
        this.centerBoilYn = centerBoilYn;
        this.localBoilYn = localBoilYn;
        this.rfgYn = rfgYn;
        this.bedYn = bedYn;
        this.laundryYn = laundryYn;
        this.airConditionerYn = airConditionerYn;
        this.microwaveYn = microwaveYn;
        this.gasStoveYn = gasStoveYn;
        this.inductionYn = inductionYn;
        this.closetYn = closetYn;
        this.tvYn = tvYn;
        this.elevatorYn = elevatorYn;
    }

    public static HouseOptionVillaDto toDto(HouseOptionVilla entity){
        HouseOptionVillaDto dto = new HouseOptionVillaDto();
        dto.setHouseOptionVillaId(entity.getHouseOptionVillaId());
        dto.setHouseOnSaleVillaId(entity.getHouseOnSaleVilla().getHouseOnSaleVillaId());
        dto.setElectricYn(entity.getElectricYn());
        dto.setGasYn(entity.getGasYn());
        dto.setWaterYn(entity.getWaterYn());
        dto.setInternetYn(entity.getInternetYn());
        dto.setTvConnectYn(entity.getTvConnectYn());
        dto.setPersonalBoilYn(entity.getPersonalBoilYn());
        dto.setCenterBoilYn(entity.getCenterBoilYn());
        dto.setLocalBoilYn(entity.getLocalBoilYn());
        dto.setRfgYn(entity.getRfgYn());
        dto.setBedYn(entity.getBedYn());
        dto.setLaundryYn(entity.getLaundryYn());
        dto.setAirConditionerYn(entity.getAirConditionerYn());
        dto.setMicrowaveYn(entity.getMicrowaveYn());
        dto.setGasStoveYn(entity.getGasStoveYn());
        dto.setInductionYn(entity.getInductionYn());
        dto.setClosetYn(entity.getClosetYn());
        dto.setTvYn(entity.getTvYn());
        dto.setElevatorYn(entity.getElevatorYn());

        dto.setCreatedTime(entity.getCreatedTime());
        dto.setUpdatedTime(entity.getUpdatedTime());
        return dto;
    }

    public static HouseOptionVilla toEntity(HouseOptionVillaDto dto, HouseOnSaleVilla houseOnSaleVilla) {

        HouseOptionVilla entity = HouseOptionVilla.builder()
                .houseOptionVillaId(dto.getHouseOptionVillaId())
                .houseOnSaleVilla(houseOnSaleVilla)
                .electricYn(dto.getElectricYn())
                .gasYn(dto.getGasYn())
                .waterYn(dto.getWaterYn())
                .internetYn(dto.getInternetYn())
                .tvConnectYn(dto.getTvConnectYn())
                .personalBoilYn(dto.getPersonalBoilYn())
                .centerBoilYn(dto.getCenterBoilYn())
                .localBoilYn(dto.getLocalBoilYn())
                .rfgYn(dto.getRfgYn())
                .bedYn(dto.getBedYn())
                .laundryYn(dto.getLaundryYn())
                .airConditionerYn(dto.getAirConditionerYn())
                .microwaveYn(dto.getMicrowaveYn())
                .gasStoveYn(dto.getGasStoveYn())
                .inductionYn(dto.getInductionYn())
                .closetYn(dto.getClosetYn())
                .tvYn(dto.getTvYn())
                .elevatorYn(dto.getElevatorYn())
                .build();

        return entity;
    }
}
