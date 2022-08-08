package com.web.happyhouse.house.entity;

import com.web.happyhouse.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
}
