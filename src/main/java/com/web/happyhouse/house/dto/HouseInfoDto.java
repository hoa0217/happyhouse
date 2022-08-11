package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ApiModel("집 정보")
@Getter
@Setter
@NoArgsConstructor
public class HouseInfoDto {
    @ApiModelProperty(notes = "정보 ID", example = "1", required = true)
    private Long houseInfoId;           // 정보ID
    @ApiModelProperty(notes = "법정동코드", example = "1165010800", required = true)
    private String dongCode;            // 주소코드
    @ApiModelProperty(notes = "번")
    private String beon;                // 번
    @ApiModelProperty(notes = "지")
    private String ji;                  // 지
    @ApiModelProperty(notes = "지번주소")
    private String jibunAddress;        // 지번주소
    @ApiModelProperty(notes = "건물명")
    private String houseName;           // 건물명
    @ApiModelProperty(notes = "건축년도")
    private String buildYear;           // 건축년도

    @ApiModelProperty(notes = "거래 유형(아파트, 오피스텔, 원룸, 투룸)", example = "APT", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 유형

}
