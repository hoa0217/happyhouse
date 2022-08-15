package com.web.happyhouse.address.controller;

import com.web.happyhouse.address.dto.DongListDto;
import com.web.happyhouse.address.dto.GugunListDto;
import com.web.happyhouse.address.dto.SidoListDto;
import com.web.happyhouse.address.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags ={"Address Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @ApiOperation(value = "시도 리스트 조회", notes="시도 리스트 조회하기")
    @GetMapping("/sido")
    public SidoListDto getSidoList(){
        SidoListDto sidoListDto = new SidoListDto();
        sidoListDto.setSidoDtoList(addressService.searchSidoList());
        return sidoListDto;
    }


    @ApiOperation(value = "구군 리스트 조회", notes="특정 시도코드에 속하는 구군 리스트를 조회한다.")
    @ApiImplicitParam(name="sidoCode",value = "시도 코드")
    @GetMapping("/gugun/{sidoCode}")
    public GugunListDto getGugunList(@PathVariable("sidoCode") String sidoCode){
        GugunListDto gugunListDto = new GugunListDto();
        gugunListDto.setGugunDtoList(addressService.searchGugunList(sidoCode));
        return gugunListDto;
    }

    @ApiOperation(value = "동 리스트 조회", notes="특정 구군에 속하는 구군 리스트를 조회한다.")
    @ApiImplicitParam(name="gugunCode", value = "구군 코드")
    @GetMapping("/dong/{gugunCode}")
    public DongListDto getDongList(@PathVariable("gugunCode") String gugunCode){
        DongListDto dongListDto = new DongListDto();
        dongListDto.setDongDtoList(addressService.searchDongList(gugunCode.substring(0,2), gugunCode));
        return dongListDto;
    }

}
