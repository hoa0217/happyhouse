package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaMapRs;
import com.web.happyhouse.house.service.VillaService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags ={"빌라 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/villa")
public class VillaController {

    private final VillaService villaService;

    @ApiOperation(value = "동에 있는 원룸 정보 리스트 조회", notes="동에 해당하는 원룸 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/map/oneroom/{dongCode}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 해당 동 원룸정보 조회를 성공했습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseOnSaleVillaMapRs> searchOneRoomMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, villaService.searchHouseOnSaleList(dongCode, HouseType.ONEROOM));
    }

    @ApiOperation(value = "동에 있는 투룸 정보 리스트 조회", notes="동에 해당하는 투룸 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/map/tworoom/{dongCode}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 해당 동 투룸정보 조회를 성공했습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseOnSaleVillaMapRs> searchTwoRoomMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, villaService.searchHouseOnSaleList(dongCode, HouseType.TWOROOM));
    }

    @ApiOperation(value = "특정 원룸에 대한 매물 정보 리스트", notes="클릭한 원룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="jibunAddress", value = "jibunAddress")
    @GetMapping("/list/oneroom/{jibunAddress}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 선택한 원룸 매물리스트 조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 원룸 매물리스트 찾기를 실패했습니다."),
    })
    public ResponseDto<HouseOnSaleVillaListRs> getOneRoomOnSaleList(@PathVariable("jibunAddress") String jibunAddress){
        return ResponseDto.res(ResponseCode.OK, villaService.getHouseOnSaleVilla(jibunAddress, HouseType.ONEROOM));
    }

    @ApiOperation(value = "특정 투룸 대한 매물 정보 리스트", notes="클릭한 투룸 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="jibunAddress", value = "jibunAddress")
    @GetMapping("list/tworoom/{jibunAddress}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 선택한 투룸 매물리스트 조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 투룸 매물리스트 찾기를 실패했습니다."),
    })
    public ResponseDto<HouseOnSaleVillaListRs> getTwoRoomOnSaleList(@PathVariable("jibunAddress") String jibunAddress){
        return ResponseDto.res(ResponseCode.OK, villaService.getHouseOnSaleVilla(jibunAddress, HouseType.TWOROOM));
    }

    @ApiOperation(value = "클릭한 원룸/투룸 상세 정보", notes="클릭한 매물에 해당하는 상세 정보 (새로운탭) \n only 원룸, 투룸")
    @ApiImplicitParam(name="houseOnSaleVillaId", value = "houseOnSaleVillaId")
    @GetMapping("/detail/{houseOnSaleVillaId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 선택한 원룸/투룸 매물정보 조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 원룸/투룸 매물정보 찾기를 실패했습니다."),
    })
    public ResponseDto<HouseOnSaleVillaDetailRs> getOnSaleVillaDetail(@PathVariable("houseOnSaleVillaId") Long houseOnSaleVillaId){
        return ResponseDto.res(ResponseCode.OK, villaService.getHouseOnSaleVillaDetail(houseOnSaleVillaId));
    }

}
