package com.web.happyhouse.house.dto.response;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import com.web.happyhouse.house.dto.HouseInfoDto;
import com.web.happyhouse.house.entity.HouseInfo;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOption;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("아파트,오피스텔 매물 응답 DTO")
@Getter
@Setter
@NoArgsConstructor
public class HouseOnSaleRs {

    @NotNull
    @ApiModelProperty(value = "집 정보", required = true)
    private HouseInfoDto houseInfoDto;

    @NotNull
    @ApiModelProperty(value = "매물ID", example = "1")
    private Long houseOnSaleId;             // 매물ID

    @ApiModelProperty(value = "계약면적", example = "36.66")
    private double contractArea;            // 계약면적

    @ApiModelProperty(value = "전용면적", example = "25.22")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(value = "총층", example = "15")
    private String totalFloor;              // 총층

    @ApiModelProperty(value = "해당층", example = "10")
    private String floor;                   // 해당층

    @ApiModelProperty(value = "방수", example = "2")
    private String roomCount;               // 방수

    @ApiModelProperty(value = "욕실수", example = "1")
    private String bathCount;               // 욕실수

    @ApiModelProperty(value = "방향", example = "SOUTH", allowableValues = "EAST, WEST, NORTH, SOUTH, SOUTHEAST, NORTHEAST, SOUTHWEST, NORTHWEST")
    @Enumerated(EnumType.STRING)
    private DirType dirType;                // 방향

    @ApiModelProperty(value = "추차대수", example = "1")
    private String parkCount;               // 추차대수

    @ApiModelProperty(value = "입주가능일", example = "20230112")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래 유형(매매, 전세, 월세)", example = "MAEMAE", allowableValues = "MAEMAE, JEONSE, WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;              // 거래 유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)", example = "45000")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세", example = "50")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비", example = "10")
    private BigDecimal mngFee;              // 관리비

    @NotNull
    @ApiModelProperty(value = "옵션ID", example = "1", required = true)
    private Long houseOptionId;

    @ApiModelProperty(value = "전기포함유무")
    private Boolean electricYn;

    @ApiModelProperty(value = "가스포함유무")
    private Boolean gasYn;

    @ApiModelProperty(value = "수도포함유무")
    private Boolean waterYn;

    @ApiModelProperty(value = "인터넷포함유무")
    private Boolean internetYn;

    @ApiModelProperty(value = "TV연결포함유무")
    private Boolean tvConnectYn;

    @ApiModelProperty(value = "개인난방")
    private Boolean personalBoilYn;

    @ApiModelProperty(value = "중앙난방")
    private Boolean centerBoilYn;

    @ApiModelProperty(value = "지역난방")
    private Boolean localBoilYn;

    @ApiModelProperty(value = "냉장고유무")
    private Boolean rfgYn;

    @ApiModelProperty(value = "침대유무")
    private Boolean bedYn;

    @ApiModelProperty(value = "세탁기유무")
    private Boolean laundryYn;

    @ApiModelProperty(value = "에어컨유무")
    private Boolean airConditionerYn;

    @ApiModelProperty(value = "전자레인지유무")
    private Boolean microwaveYn;

    @ApiModelProperty(value = "가스레인지유무")
    private Boolean gasStoveYn;

    @ApiModelProperty(value = "인덕션유무")
    private Boolean inductionYn;

    @ApiModelProperty(value = "옷장유무")
    private Boolean closetYn;

    @ApiModelProperty(value = "TV유무")
    private Boolean tvYn;

    @ApiModelProperty(value = "승강기유무")
    private Boolean elevatorYn;

    static public HouseOnSaleRs toHouseOnSaleRs(HouseOnSale houseOnSale, HouseOption houseOption){
        HouseOnSaleRs rs = new HouseOnSaleRs();
        rs.houseOnSaleId = houseOnSale.getHouseOnSaleId();
        rs.contractArea = houseOnSale.getContractArea();
        rs.netLeasableArea = houseOnSale.getNetLeasableArea();
        rs.totalFloor = houseOnSale.getTotalFloor();
        rs.floor = houseOnSale.getFloor();
        rs.roomCount = houseOnSale.getRoomCount();
        rs.bathCount = houseOnSale.getBathCount();
        rs.dirType = houseOnSale.getDirType();
        rs.parkCount = houseOnSale.getParkCount();
        rs.movingDate = houseOnSale.getMovingDate();
        rs.dealType = houseOnSale.getDealType();
        rs.price = houseOnSale.getPrice();
        rs.rent = houseOnSale.getRent();
        rs.mngFee = houseOnSale.getMngFee();
        rs.houseInfoDto = HouseInfo.toDto(houseOnSale.getHouseInfo());

        rs.houseOptionId = houseOption.getHouseOptionId();
        rs.electricYn = houseOption.getElectricYn();
        rs.gasYn = houseOption.getGasYn();
        rs.waterYn = houseOption.getWaterYn();
        rs.internetYn = houseOption.getInternetYn();
        rs.tvConnectYn = houseOption.getTvConnectYn();
        rs.personalBoilYn = houseOption.getPersonalBoilYn();
        rs.centerBoilYn = houseOption.getCenterBoilYn();
        rs.localBoilYn = houseOption.getLocalBoilYn();
        rs.rfgYn = houseOption.getRfgYn();
        rs.bedYn = houseOption.getBedYn();
        rs.laundryYn = houseOption.getLaundryYn();
        rs.airConditionerYn = houseOption.getAirConditionerYn();
        rs.microwaveYn = houseOption.getMicrowaveYn();
        rs.gasStoveYn = houseOption.getGasStoveYn();
        rs.inductionYn = houseOption.getInductionYn();
        rs.closetYn = houseOption.getClosetYn();
        rs.tvYn = houseOption.getTvYn();
        rs.elevatorYn = houseOption.getElevatorYn();
        return rs;
    }
}
