package com.web.happyhouse.address.service;

import com.web.happyhouse.address.dto.DongDto;
import com.web.happyhouse.address.dto.GugunDto;
import com.web.happyhouse.address.dto.SidoDto;

import java.util.List;

public interface AddressService {

    /**
     * 시/도 select리스트
     * @return
     */
    List<SidoDto> searchSidoList();

    /**
     * 구/군 select리스트
     * @param sidoCode
     * @return
     */
    List<GugunDto> searchGugunList(String sidoCode);

    /**
     * 동 select리스트
     * @param gugunCode
     * @return
     */
    List<DongDto> searchDongList(String sidoCode, String gugunCode);
}
