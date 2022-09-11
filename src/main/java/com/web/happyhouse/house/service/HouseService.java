package com.web.happyhouse.house.service;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;

public interface HouseService {

    /**
     * 동에 해당하는 집 정보 List (Map)
     * only 오피스텔, 아파트
     *
     * @param dongCode
     * @param houseType
     * @return
     */
    HouseInfoListRs searchHouseInfoList(String dongCode, HouseType houseType);

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
     * 클릭한 houseInfo에 해당하는 매물 정보 List (사이드바)
     * only 오피스텔, 아파트
     *
     * @param houseInfoId
     * @return
     */
    HouseOnSaleListRs getHouseOnSale(Long houseInfoId);

    /**
     * 클릭한 우편번호에 해당하는 매물 정보 List (사이드바)
     * only 원룸, 투룸
     *
     * @param zoneCode
     * @return
     */
    HouseOnSaleVillaListRs getHouseOnSaleVilla(String zoneCode, HouseType houseType);

    /**
     * 클릭한 houseOnSale에 해당하는 상세 정보 (새로운탭)
     * only 오피스텔, 아파트
     *
     * @param houseOnSaleId
     * @return
     */
    HouseOnSaleDetailRs getHouseOnSaleDetail(Long houseOnSaleId);

    /**
     * 클릭한 houseOnSale에 해당하는 상세 정보 (새로운탭)
     * only 원룸, 투룸
     *
     * @param houseOnSaleVillaId
     * @return
     */
    HouseOnSaleVillaDetailRs getHouseOnSaleVillaDetail(Long houseOnSaleVillaId);
}
