package com.web.happyhouse.house.service;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseInfoDto;
import com.web.happyhouse.house.dto.HouseOnSaleDto;

import java.util.List;

public interface HouseService {

    /**
     * 동에 해당하는 아파트or오피스텔 정보 List (Map)
     *
     * @param dongCode
     * @param houseType
     * @return
     */
    List<HouseInfoDto> searchHouseInfoList(String dongCode, HouseType houseType);

    /**
     * 클릭한 houseInfo에 해당하는 매물 정보 List (사이드바)
     *
     * @param houseInfoId
     * @return
     */
    List<HouseOnSaleDto> getHouseOnSaleDto(Long houseInfoId);

}
