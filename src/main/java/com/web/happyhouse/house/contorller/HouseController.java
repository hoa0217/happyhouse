package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;
import com.web.happyhouse.house.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/house")
public class HouseController {
    private final HouseService houseService;

    /**
     * 동에 해당하는 아파트 정보 List (Map)
     *
     * @param dongCode
     * @return
     */
    @GetMapping("/apt/map/{dongCode}")
    HouseInfoListDto searchAptMap(@PathVariable("dongCode") String dongCode){
        return houseService.searchHouseInfoList(dongCode, HouseType.APT);
    }

    /**
     * 동에 해당하는 오피스텔 정보 List (Map)
     *
     * @param dongCode
     * @return
     */
    @GetMapping("/officetel/map/{dongCode}")
    HouseInfoListDto searchOfficetelMap(@PathVariable("dongCode") String dongCode){
        return houseService.searchHouseInfoList(dongCode, HouseType.OFFICETEL);
    }

    /**
     * 동에 해당하는 원룸 정보 List (Map)
     *
     * @param dongCode
     * @return
     */
    @GetMapping("/oneroom/map/{dongCode}")
    HouseOnSaleVillaMapDto searchOneRoomMap(@PathVariable("dongCode") String dongCode){
        return houseService.searchHouseOnSaleList(dongCode, HouseType.ONEROOM);
    }

    /**
     * 동에 해당하는 투룸 정보 List (Map)
     *
     * @param dongCode
     * @return
     */
    @GetMapping("/tworoom/map/{dongCode}")
    HouseOnSaleVillaMapDto searchTwoRoomMap(@PathVariable("dongCode") String dongCode){
        return houseService.searchHouseOnSaleList(dongCode, HouseType.TWOROOM);
    }

    /**
     * 클릭한 아파트 매물 정보 List (사이드바)
     *
     * @param houseInfoId
     * @return
     */
    @GetMapping("/apt/list/{houseInfoId}")
    HouseOnSaleListDto getAptOnSaleList(@PathVariable("houseInfoId") Long houseInfoId){
        return houseService.getHouseOnSale(houseInfoId);
    }

    /**
     * 클릭한 오피스텔 매물 정보 List (사이드바)
     *
     * @param houseInfoId
     * @return
     */
    @GetMapping("/officetel/list/{houseInfoId}")
    HouseOnSaleListDto getOfficetelOnSaleList(@PathVariable("houseInfoId") Long houseInfoId){
        return houseService.getHouseOnSale(houseInfoId);
    }

    /**
     * 클릭한 원룸 매물 정보 List (사이드바)
     *
     * @param zoneCode
     * @return
     */
    @GetMapping("/oneroom/list/{zoneCode}")
    HouseOnSaleVillaListDto getOneRoomOnSaleList(@PathVariable("zoneCode") String zoneCode){
        return houseService.getHouseOnSaleVilla(zoneCode, HouseType.ONEROOM);
    }

    /**
     * 클릭한 투룸 매물 정보 List (사이드바)
     *
     * @param zoneCode
     * @return
     */
    @GetMapping("/tworoom/list/{zoneCode}")
    HouseOnSaleVillaListDto getTwoRoomOnSaleList(@PathVariable("zoneCode") String zoneCode){
        return houseService.getHouseOnSaleVilla(zoneCode, HouseType.TWOROOM);
    }

    /**
     * 클릭한 매물에 해당하는 상세 정보 (새로운탭)
     * only 오피스텔, 아파트
     *
     * @param houseOnSaleId
     * @return
     */
    @GetMapping("/detail/{houseOnSaleId}")
    HouseOnSaleDetailDto getOnSaleDetail(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        return houseService.getHouseOnSaleDetail(houseOnSaleId);
    }

    /**
     * 클릭한 매물에 해당하는 상세 정보 (새로운탭)
     * only 원룸, 투룸
     *
     * @param houseOnSaleVillaId
     * @return
     */
    @GetMapping("/detail/villa/{houseOnSaleVillaId}")
    HouseOnSaleVillaDetailDto getOnSaleVillaDetail(@PathVariable("houseOnSaleVillaId") Long houseOnSaleVillaId){
        return houseService.getHouseOnSaleVillaDetail(houseOnSaleVillaId);
    }

}
