package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.entity.HouseOnSale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class HouseOptionDto {

    private Long houseOptionId;             // 옵션ID

    private Long houseOnSaleId;        // 매물ID

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
}
