package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.response.HouseInfoListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleListRs;
import com.web.happyhouse.house.dto.createRequest.HouseOnSaleCreateRq;
import com.web.happyhouse.house.dto.response.HouseOnSaleRs;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateRq;
import com.web.happyhouse.house.service.AptOfficeService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"아파트/오피스텔 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/house")
public class AptOfficeController {

    private final AptOfficeService aptOfficeService;

    @ApiOperation(value = "동에 있는 아파트정보 리스트 조회", notes="동에 해당하는 아파트 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/map/apt/{dongCode}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 해당 동 아파트정보 조회를 성공했습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseInfoListRs> searchAptMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, aptOfficeService.searchHouseInfoList(dongCode, HouseType.APT));
    }

    @ApiOperation(value = "동에 있는 오피스텔정보 리스트 조회", notes="동에 해당하는 오피스텔 정보 List (Map)")
    @ApiImplicitParam(name="dongCode", value = "동 코드")
    @GetMapping("/map/officetel/{dongCode}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 해당 동 오피스텔정보 조회를 성공했습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseInfoListRs> searchOfficetelMap(@PathVariable("dongCode") String dongCode){
        return ResponseDto.res(ResponseCode.OK, aptOfficeService.searchHouseInfoList(dongCode, HouseType.OFFICETEL));
    }

    @ApiOperation(value = "클릭한 아파트/오피스텔에 대한 매물 정보 리스트", notes="클릭한 아파트/오피스텔 매물 정보 List (사이드바)")
    @ApiImplicitParam(name="houseInfoId", value = "houseInfoId")
    @GetMapping("/list/{houseInfoId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 선택한 아파트/오피스텔의 매물리스트 조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔정보 찾기를 실패했습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseOnSaleListRs> getHouseOnSaleList(@PathVariable("houseInfoId") Long houseInfoId){
        return ResponseDto.res(ResponseCode.OK, aptOfficeService.getHouseOnSaleList(houseInfoId));
    }

    @ApiOperation(value = "클릭한 아파트/오피스텔 매물 상세 정보", notes="클릭한 아파트/오피스텔에 해당하는 매물 상세 정보 (새로운탭)")
    @ApiImplicitParam(name="houseOnSaleId", value = "houseOnSaleId")
    @GetMapping("/detail/{houseOnSaleId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 선택한 아파트/오피스텔 매물정보 조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물정보 찾기를 실패했습니다."),
    })
    public ResponseDto<HouseOnSaleDetailRs> getOnSaleDetail(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        return ResponseDto.res(ResponseCode.OK, aptOfficeService.getHouseOnSaleDetail(houseOnSaleId));
    }

    // TODO: 부동산중개인 권한설정 필요
    @ApiOperation(value = "오피스텔/아파트 매물 찾기", notes="오피스텔/아파트 매물 찾기")
    @GetMapping("/mng/{houseOnSaleId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물찾기를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다.")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseOnSaleRs> getHouseOnSale(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        return ResponseDto.res(ResponseCode.OK, "선택한 아파트/오피스텔 매물찾기를 완료했습니다.", aptOfficeService.getHouseOnSale(houseOnSaleId));
    }

    @ApiOperation(value = "오피스텔/아파트 매물 생성", notes="오피스텔/아파트 매물 생성")
    @PostMapping("/mng")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED 오피스텔/아파트 매물생성을 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔정보 찾기를 실패했습니다.")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto<Long> createHouseOnSale(
            @ApiParam(value = "생성 요청 form", required = true)
            @Valid @RequestBody HouseOnSaleCreateRq createRq){
        return ResponseDto.res(ResponseCode.CREATED, "선택한 오피스텔/아파트 매물생성을 완료했습니다.", aptOfficeService.saveHouseOnSale(createRq));
    }

    @ApiOperation(value = "오피스텔/아파트 매물 업데이트", notes="오피스텔/아파트 매물 업데이트")
    @PatchMapping("/mng")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물업데이트를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다.")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<Long> updateHouseOnSale(
            @ApiParam(value = "업데이트 요청 form", required = true)
            @Valid @RequestBody HouseOnSaleUpdateRq updateRq){
        return ResponseDto.res(ResponseCode.OK, "선택한 오피스텔/아파트 매물업데이트를 완료했습니다.", aptOfficeService.updateHouseOnSale(updateRq));
    }

    @ApiOperation(value = "오피스텔/아파트 매물 삭제", notes="오피스텔/아파트 매물 삭제")
    @DeleteMapping("/mng/{houseOnSaleId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물삭제를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다.")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto deleteHouseOnSale(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        aptOfficeService.deleteHouseOnSale(houseOnSaleId);
        return ResponseDto.res(ResponseCode.OK, "선택한 오피스텔/아파트 매물삭제를 완료했습니다.");
    }

}
