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
    @ApiModelProperty(value = "집정보ID", example = "0", required = true)
    private Long houseInfoId;           // 집정보ID
    @ApiModelProperty(value = "법정동코드", example = "1111010700", required = true)
    private String dongCode;            // 주소코드
    @ApiModelProperty(value = "지번", example = "156")
    private String jiBun;               // 지번
    @ApiModelProperty(value = "지번주소", example = "서울특별시 종로구 적선동 156")
    private String jibunAddress;        // 지번주소
    @ApiModelProperty(value = "건물명", example = "광화문 플래티넘")
    private String houseName;           // 건물명
    @ApiModelProperty(value = "건축년도", example = "2003")
    private String buildYear;           // 건축년도

    @ApiModelProperty(value = "건물 유형(아파트, 오피스텔, 원룸, 투룸)", example = "OFFICETEL", allowableValues = "APT, OFFICETEL, ONEROOM, TWOROOM")
    @Enumerated(EnumType.STRING)
    private HouseType houseType;        // 건물 유형
}
