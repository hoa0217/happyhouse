package com.web.happyhouse.house.contorller;

import com.web.happyhouse.house.dto.createRequest.HouseOnSaleCreateRq;
import com.web.happyhouse.house.dto.response.HouseOnSaleRs;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateRq;
import com.web.happyhouse.house.service.AptOfficeService;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"아파트/오피스텔 관리 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/house")
@PreAuthorize("hasAnyRole('AGENT','ADMIN')")
public class AptOfficeMngController {

    private final AptOfficeService aptOfficeService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "오피스텔/아파트 매물 찾기", notes="오피스텔/아파트 매물 찾기")
    @GetMapping("/mng/{houseOnSaleId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물찾기를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<HouseOnSaleRs> getHouseOnSale(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        return ResponseDto.res(ResponseCode.OK, "선택한 아파트/오피스텔 매물찾기를 완료했습니다.", aptOfficeService.getHouseOnSale(houseOnSaleId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "오피스텔/아파트 매물 생성", notes="오피스텔/아파트 매물 생성")
    @PostMapping("/mng")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED 오피스텔/아파트 매물생성을 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔정보 찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto<Long> createHouseOnSale(
            @ApiParam(value = "생성 요청 form", required = true)
            @Valid @RequestBody HouseOnSaleCreateRq createRq){
        return ResponseDto.res(ResponseCode.CREATED, "선택한 오피스텔/아파트 매물생성을 완료했습니다.", aptOfficeService.saveHouseOnSale(createRq));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "오피스텔/아파트 매물 업데이트", notes="오피스텔/아파트 매물 업데이트")
    @PatchMapping("/mng")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물업데이트를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<Long> updateHouseOnSale(
            @ApiParam(value = "업데이트 요청 form", required = true)
            @Valid @RequestBody HouseOnSaleUpdateRq updateRq){
        return ResponseDto.res(ResponseCode.OK, "선택한 오피스텔/아파트 매물업데이트를 완료했습니다.", aptOfficeService.updateHouseOnSale(updateRq));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "오피스텔/아파트 매물 삭제", notes="오피스텔/아파트 매물 삭제")
    @DeleteMapping("/mng/{houseOnSaleId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 오피스텔/아파트 매물삭제를 완료했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 선택한 아파트/오피스텔 매물찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto deleteHouseOnSale(@PathVariable("houseOnSaleId") Long houseOnSaleId){
        aptOfficeService.deleteHouseOnSale(houseOnSaleId);
        return ResponseDto.res(ResponseCode.OK, "선택한 오피스텔/아파트 매물삭제를 완료했습니다.");
    }
}
