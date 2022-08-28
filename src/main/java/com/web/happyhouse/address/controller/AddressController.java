package com.web.happyhouse.address.controller;

import com.web.happyhouse.address.dto.*;
import com.web.happyhouse.address.service.AddressService;
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

import java.util.List;

@Api(tags ={"Address 선택 Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @ApiOperation(value = "시도 리스트 조회", notes="시도 리스트 조회하기")
    @GetMapping("/sido")
    public ResponseDto<List<SidoDto>> getSidoList(){
        return ResponseDto.res(ResponseCode.OK, addressService.searchSidoList());
    }

    @ApiOperation(value = "구군 리스트 조회", notes="특정 시도코드에 속하는 구군 리스트를 조회한다.")
    @ApiImplicitParam(name="sidoCode",value = "시도 코드")
    @GetMapping("/gugun/{sidoCode}")
    public ResponseDto<List<GugunDto>> getGugunList(@PathVariable("sidoCode") String sidoCode){
        return ResponseDto.res(ResponseCode.OK, addressService.searchGugunList(sidoCode));
    }

    @ApiOperation(value = "동 리스트 조회", notes="특정 구군에 속하는 구군 리스트를 조회한다.")
    @ApiImplicitParam(name="gugunCode", value = "구군 코드")
    @GetMapping("/dong/{gugunCode}")
    public ResponseDto<List<DongDto>> getDongList(@PathVariable("gugunCode") String gugunCode){

        List<DongDto> dongDtoList = null;

        if(gugunCode.equals("3611")){
            // 세종특별자치시만 4자리 시도코드를 가짐
            dongDtoList = addressService.searchDongList("3611", gugunCode);
        }
        else{
            dongDtoList = addressService.searchDongList(gugunCode.substring(0,2), gugunCode);
        }
        return ResponseDto.res(ResponseCode.OK, dongDtoList);
    }

}
