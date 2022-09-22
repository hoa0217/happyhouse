package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ApiModel("아파트,오피스텔 DTO")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HouseInfoDto {
    @ApiModelProperty(value = "집정보ID", example = "1", required = true)
    private Long houseInfoId;           // 집정보ID
    @ApiModelProperty(value = "법정동코드", example = "1165010800", required = true)
    private String dongCode;            // 주소코드
    @ApiModelProperty(value = "지번")
    private String jiBun;               // 지번
    @ApiModelProperty(value = "지번주소")
    private String jibunAddress;        // 지번주소
    @ApiModelProperty(value = "건물명")
    private String houseName;           // 건물명
    @ApiModelProperty(value = "건축년도")
    private String buildYear;           // 건축년도

    @ApiModelProperty(value = "거래 유형(아파트, 오피스텔, 원룸, 투룸)", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 유형

}
