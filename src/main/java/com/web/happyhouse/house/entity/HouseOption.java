package com.web.happyhouse.house.entity;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.house.dto.HouseInfoDto;
import com.web.happyhouse.house.dto.HouseOnSaleDto;
import com.web.happyhouse.house.dto.HouseOptionDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HouseOption extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "house_option_id")
    private Long houseOptionId;             // 옵션ID

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_on_sale_id")
    private HouseOnSale houseOnSale;        // 매물ID

    private Boolean electricYn;             // 전기포함유무
    private Boolean gasYn;                  // 가스포함유무
    private Boolean waterYn;                // 수도포함유무
    private Boolean internetYn;             // 인터넷포함유무
    private Boolean tvConnectYn;

    private Boolean personalBoilYn;
    private Boolean centerBoilYn;
    private Boolean localBoilYn;

    private Boolean rfgYn;
    private Boolean bedYn;
    private Boolean laundryYn;
    private Boolean airConditionerYn;
    private Boolean microwaveYn;
    private Boolean gasStoveYn;
    private Boolean inductionYn;
    private Boolean closetYn;

    private Boolean tvYn;
    private Boolean elevatorYn;

    @Builder
    private HouseOption(Long houseOptionId, HouseOnSale houseOnSale, Boolean electricYn, Boolean gasYn, Boolean waterYn, Boolean internetYn, Boolean tvConnectYn, Boolean personalBoilYn, Boolean centerBoilYn, Boolean localBoilYn, Boolean rfgYn, Boolean bedYn, Boolean laundryYn, Boolean airConditionerYn, Boolean microwaveYn, Boolean gasStoveYn, Boolean inductionYn, Boolean closetYn, Boolean tvYn, Boolean elevatorYn) {
        this.houseOptionId = houseOptionId;
        this.houseOnSale = houseOnSale;
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

    public static HouseOptionDto toDto(HouseOption entity){
        HouseOptionDto dto = new HouseOptionDto();
        dto.setHouseOptionId(entity.getHouseOptionId());
        dto.setHouseOnSaleId(entity.getHouseOnSale().getHouseOnSaleId());
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

        return dto;
    }

    public static HouseOption toEntity(HouseOptionDto dto, HouseOnSale houseOnSale) {

        HouseOption entity = HouseOption.builder()
                .houseOptionId(dto.getHouseOptionId())
                .houseOnSale(houseOnSale)
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
