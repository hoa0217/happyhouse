package com.web.happyhouse.house.service;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaMapRs;

public interface VillaService {

    /**
     * 동에 해당하는 집 정보 List (Map)
     * only 원룸, 투룸
     *
     * @param dongCode
     * @param houseType
     * @return
     */
    HouseOnSaleVillaMapRs searchHouseOnSaleList(String dongCode, HouseType houseType);

    /**
     * 클릭한 주소에 해당하는 매물 정보 List (사이드바)
     * only 원룸, 투룸
     *
     * @param jibunAddress
     * @return
     */
    HouseOnSaleVillaListRs getHouseOnSaleVilla(String jibunAddress, HouseType houseType);

    /**
     * 클릭한 houseOnSale에 해당하는 상세 정보 (새로운탭)
     * only 원룸, 투룸
     *
     * @param houseOnSaleVillaId
     * @return
     */
    HouseOnSaleVillaDetailRs getHouseOnSaleVillaDetail(Long houseOnSaleVillaId);
}
