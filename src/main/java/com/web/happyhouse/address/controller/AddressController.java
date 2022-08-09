package com.web.happyhouse.address.controller;

import com.web.happyhouse.address.dto.DongListDto;
import com.web.happyhouse.address.dto.GugunListDto;
import com.web.happyhouse.address.dto.SidoListDto;
import com.web.happyhouse.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address/sido")
    public SidoListDto getSidoList(){
        SidoListDto sidoListDto = new SidoListDto();
        sidoListDto.setSidoDtoList(addressService.searchSidoList());
        return sidoListDto;
    }

    @GetMapping("/address/gugun/{sidocode}")
    public GugunListDto getGugunList(@PathVariable String sidoCode){
        GugunListDto gugunListDto = new GugunListDto();
        gugunListDto.setGugunDtoList(addressService.searchGugunList(sidoCode));
        return gugunListDto;
    }

    @GetMapping("/address/dong/{gugunCode}")
    public DongListDto getDongList(@PathVariable String gugunCode){
        DongListDto dongListDto = new DongListDto();
        dongListDto.setDongDtoList(addressService.searchDongList(gugunCode.substring(0,2), gugunCode));
        return dongListDto;
    }

}
