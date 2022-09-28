package com.web.happyhouse.house.dto;

import com.web.happyhouse.base.BaseDto;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.DirType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@ApiModel("아파트,오피스텔 매물 DTO")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HouseOnSaleDto extends BaseDto {
    @ApiModelProperty(value = "거래ID", example = "2")
    private Long houseOnSaleId;             // 거래ID

    @ApiModelProperty(value = "계약면적", example = "45.36")
    private double contractArea;            // 계약면적

    @ApiModelProperty(value = "전용면적", example = "36.06")
    private double netLeasableArea;         // 전용면적

    @ApiModelProperty(value = "총층", example = "15")
    private String totalFloor;              // 총층

    @ApiModelProperty(value = "해당층", example = "11")
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

    @ApiModelProperty(value = "입주가능일", example = "20230217")
    private String movingDate;              // 입주가능일

    @ApiModelProperty(value = "거래 유형(매매, 전세, 월세)", example = "WOLSE", allowableValues = "MAEMAE, JEONSE, WOLSE")
    @Enumerated(EnumType.STRING)
    private DealType dealType;              // 거래 유형(매매, 전세, 월세)

    @ApiModelProperty(value = "가격(매매가, 전세가, 월세보증금)", example = "20000")
    private BigDecimal price;               // 가격(매매가, 전세가, 월세보증금)

    @ApiModelProperty(value = "월세", example = "15")
    private BigDecimal rent;                // 월세

    @ApiModelProperty(value = "관리비", example = "20")
    private BigDecimal mngFee;              // 관리비

    @ApiModelProperty(value = "집정보 ID", example = "1")
    private Long houseInfoId;               // 집정보ID

    @ApiModelProperty(value = "생성자", example = "1")
    private Long createBy;

    @ApiModelProperty(value = "수정자", example = "1")
    private Long updateBy;

}
