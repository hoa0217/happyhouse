package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;
import com.web.happyhouse.house.service.HouseService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags ={"집 정보 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/house")
public class HouseController {
    private final HouseService houseService;

    @ApiOperation(value = "동에 있는 아파트 정보 리스트 조회", notes="동에 해당하는 아파트 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/apt/map/{dongCode}")
    public ResponseDto<HouseInfoListRs> searchAptMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, houseService.searchHouseInfoList(dongCode, HouseType.APT));
    }

    @ApiOperation(value = "동에 있는 오피스텔 정보 리스트 조회", notes="동에 해당하는 오피스텔 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/officetel/map/{dongCode}")
    public ResponseDto<HouseInfoListRs> searchOfficetelMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, houseService.searchHouseInfoList(dongCode, HouseType.OFFICETEL));
    }

    @ApiOperation(value = "동에 있는 원룸 정보 리스트 조회", notes="동에 해당하는 원룸 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/oneroom/map/{dongCode}")
    public ResponseDto<HouseOnSaleVillaMapRs> searchOneRoomMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, houseService.searchHouseOnSaleList(dongCode, HouseType.ONEROOM));
    }

    @ApiOperation(value = "동에 있는 투룸 정보 리스트 조회", notes="동에 해당하는 투룸 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/tworoom/map/{dongCode}")
    public ResponseDto<HouseOnSaleVillaMapRs> searchTwoRoomMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, houseService.searchHouseOnSaleList(dongCode, HouseType.TWOROOM));
    }

    @ApiOperation(value = "특정 아파트에 대한 매물 정보 리스트", notes="클릭한 아파트 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="houseInfoId", value = "houseInfoId")
    @GetMapping("/apt/list/{houseInfoId}")
    public ResponseDto<HouseOnSaleListRs> getAptOnSaleList(@PathVariable("houseInfoId") Long houseInfoId){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSale(houseInfoId));
    }

    @ApiOperation(value = "특정 오피스텔에 대한 매물 정보 리스트", notes="클릭한 오피스텔 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="houseInfoId", value = "houseInfoId")
    @GetMapping("/officetel/list/{houseInfoId}")
    public ResponseDto<HouseOnSaleListRs> getOfficetelOnSaleList(@PathVariable("houseInfoId") Long houseInfoId){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSale(houseInfoId));
    }

    @ApiOperation(value = "특정 원룸에 대한 백엔드 무료 배포매물 정보 리스트", notes="클릭한 원룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="zoneCode", value = "zoneCode")
    @GetMapping("/oneroom/list/{zoneCode}")
    public ResponseDto<HouseOnSaleVillaListRs> getOneRoomOnSaleList(@PathVariable("zoneCode") String zoneCode){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSaleVilla(zoneCode, HouseType.ONEROOM));
    }

    @ApiOperation(value = "특정 투룸 대한 매물 정보 리스트", notes="클릭한 투룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="zoneCode", value = "zoneCode")
    @GetMapping("/tworoom/list/{zoneCode}")
    public ResponseDto<HouseOnSaleVillaListRs> getTwoRoomOnSaleList(@PathVariable("zoneCode") String zoneCode){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSaleVilla(zoneCode, HouseType.TWOROOM));
    }

    @ApiOperation(value = "클릭한 오피스텔/아파트 상세 정보", notes="클릭한 매물에 해당하는 상세 정보 (새로운탭) \n only 오피스텔, 아파트")
    @ApiImplicitParam(name="houseOnSaleId", value = "houseOnSaleId")
    @GetMapping("/detail/{houseOnSaleId}")
    public ResponseDto<HouseOnSaleDetailRs> getOnSaleDetail(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSaleDetail(houseOnSaleId));
    }

    @ApiOperation(value = "클릭한 원룸/투룸 상세 정보", notes="클릭한 매물에 해당하는 상세 정보 (새로운탭) \n only 원룸, 투룸")
    @ApiImplicitParam(name="houseOnSaleVillaId", value = "houseOnSaleVillaId")
    @GetMapping("/detail/villa/{houseOnSaleVillaId}")
    public ResponseDto<HouseOnSaleVillaDetailRs> getOnSaleVillaDetail(@PathVariable("houseOnSaleVillaId") Long houseOnSaleVillaId){
        return ResponseDto.res(ResponseCode.OK, houseService.getHouseOnSaleVillaDetail(houseOnSaleVillaId));
    }

}
