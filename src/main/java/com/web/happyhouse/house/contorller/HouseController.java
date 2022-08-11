package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;
import com.web.happyhouse.house.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags ={"House Controller"})
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
    @ApiOperation(value = "동에 있는 아파트 정보 리스트 조회", notes="동에 해당하는 아파트 정보 List (Map)")
    @ApiImplicitParam(value = "동 코드")
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
    @ApiOperation(value = "동에 있는 오피스텔 정보 리스트 조회", notes="동에 해당하는 오피스텔 정보 List (Map)")
    @ApiImplicitParam(value = "동 코드")
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
    @ApiOperation(value = "동에 있는 원룸 정보 리스트 조회", notes="동에 해당하는 원룸 정보 List (Map)")
    @ApiImplicitParam(value = "동 코드")
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
    @ApiOperation(value = "동에 있는 투룸 정보 리스트 조회", notes="동에 해당하는 투룸 정보 List (Map)")
    @ApiImplicitParam(value = "동 코드")
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
    @ApiOperation(value = "특정 아파트에 대한 매물 정보 리스트", notes="클릭한 아파트 매물 정보 List (사이드바)")
    @ApiImplicitParam(value = "houseInfoId")
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
    @ApiOperation(value = "특정 오피스텔에 대한 매물 정보 리스트", notes="클릭한 오피스텔 매물 정보 List (사이드바)")
    @ApiImplicitParam(value = "houseInfoId")
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
    @ApiOperation(value = "특정 원룸에 대한 매물 정보 리스트", notes="클릭한 원룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(value = "zoneCode")
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
    @ApiOperation(value = "특정 투룸 대한 매물 정보 리스트", notes="클릭한 투룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(value = "zoneCode")
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
    @ApiOperation(value = "클릭한 오피스텔/아파트 상세 정보", notes="클릭한 매물에 해당하는 상세 정보 (새로운탭) \n only 오피스텔, 아파트")
    @ApiImplicitParam(value = "houseOnSaleId")
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
    @ApiOperation(value = "클릭한 원룸/투룸 상세 정보", notes="클릭한 매물에 해당하는 상세 정보 (새로운탭) \n only 원룸, 투룸")
    @ApiImplicitParam(value = "houseOnSaleVillaId")
    @GetMapping("/detail/villa/{houseOnSaleVillaId}")
    HouseOnSaleVillaDetailDto getOnSaleVillaDetail(@PathVariable("houseOnSaleVillaId") Long houseOnSaleVillaId){
        return houseService.getHouseOnSaleVillaDetail(houseOnSaleVillaId);
    }

}
