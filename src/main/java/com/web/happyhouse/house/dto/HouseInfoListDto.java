package com.web.happyhouse.house.dto;

import com.web.happyhouse.house.domain.HouseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HouseInfoListDto {
    String dongCode;                        // 동코드
    HouseType houseType;                    // 집유형
    List<HouseInfoDto> houseInfoDtoList;    // 집정보 리스트
}
