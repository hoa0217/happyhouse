package com.web.happyhouse.house.service;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.createRequest.HouseOnSaleCreateRq;
import com.web.happyhouse.house.dto.response.HouseInfoListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleRs;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateRq;

public interface AptOfficeService {

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
     * 클릭한 houseInfo에 해당하는 매물 정보 List (사이드바)
     * only 오피스텔, 아파트
     *
     * @param houseInfoId
     * @return
     */
    HouseOnSaleListRs getHouseOnSaleList(Long houseInfoId);

    /**
     * 클릭한 houseOnSale에 해당하는 상세 정보 (새로운탭)
     * only 오피스텔, 아파트
     *
     * @param houseOnSaleId
     * @return
     */
    HouseOnSaleDetailRs getHouseOnSaleDetail(Long houseOnSaleId);

    /**
     * 매물 찾기
     * only 오피스텔, 아파트
     *
     * @param houseOnSaleId
     * @return
     */
    HouseOnSaleRs getHouseOnSale(Long houseOnSaleId);

    /**
     * 매물 생성
     * only 오피스텔, 아파트
     *
     * @param createRq
     * @return
     */
    Long saveHouseOnSale(HouseOnSaleCreateRq createRq);

    /**
     * 매물 수정
     * only 오피스텔, 아파트
     *
     * @param updateRq
     * @return
     */
    Long updateHouseOnSale(HouseOnSaleUpdateRq updateRq);

    /**
     * 매물 삭제
     * only 오피스텔, 아파트
     *
     * @param houseOnSaleId
     * @return
     */
    void deleteHouseOnSale(Long houseOnSaleId);

}
