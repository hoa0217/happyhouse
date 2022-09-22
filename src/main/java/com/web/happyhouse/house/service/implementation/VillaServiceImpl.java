package com.web.happyhouse.house.service.implementation;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.advice.exception.NotFoundHouseInfoException;
import com.web.happyhouse.advice.exception.NotFoundHouseOnSaleException;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseOnSaleVillaDto;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleVillaMapRs;
import com.web.happyhouse.house.entity.HouseOnSaleVilla;
import com.web.happyhouse.house.entity.HouseOptionVilla;
import com.web.happyhouse.house.repository.HouseOnSaleVillaRepository;
import com.web.happyhouse.house.repository.HouseOptionVillaRepository;
import com.web.happyhouse.house.service.VillaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VillaServiceImpl implements VillaService {

    private final DongRepository dongRepository;
    private final HouseOnSaleVillaRepository houseOnSaleVillaRepository;
    private final HouseOptionVillaRepository houseOptionVillaRepository;

    @Override
    public HouseOnSaleVillaMapRs searchHouseOnSaleList(String dongCode, HouseType houseType) {
        HouseOnSaleVillaMapRs houseOnSaleVillaMapRs = new HouseOnSaleVillaMapRs();
        Dong dong = dongRepository.findByDongCode(dongCode);

        Map<String, Long> zoneCodeToCountingMap = houseOnSaleVillaRepository.findByDongAndHouseType(dong, houseType)
                .stream()
                .collect(Collectors.groupingBy(HouseOnSaleVilla::getJibunAddress, Collectors.counting()));

        houseOnSaleVillaMapRs.setDongCode(dongCode);
        houseOnSaleVillaMapRs.setHouseType(houseType);
        houseOnSaleVillaMapRs.setJibunAddressToCountingMap(zoneCodeToCountingMap);

        return houseOnSaleVillaMapRs;
    }

    @Override
    public HouseOnSaleVillaListRs getHouseOnSaleVilla(String jibunAddress, HouseType houseType) {

        HouseOnSaleVillaListRs houseOnSaleVillaListRs = new HouseOnSaleVillaListRs();
        houseOnSaleVillaListRs.setJibunAddress(jibunAddress);
        houseOnSaleVillaListRs.setHouseType(houseType);

        List<HouseOnSaleVilla> houseOnSaleVillaList = houseOnSaleVillaRepository.findByJibunAddressAndHouseType(jibunAddress, houseType);
        if(houseOnSaleVillaList.isEmpty()){
            throw new NotFoundHouseInfoException("해당 주소(" + jibunAddress + ")의 집 정보를 찾을 수 없습니다.");
        }

        // 매물정보매핑
        Map<DealType, List<HouseOnSaleVillaDto>> dealTypeToHouseOnSaleVillaMap = houseOnSaleVillaList
                .stream()
                .map(entity -> HouseOnSaleVilla.toDto(entity))
                .collect(Collectors.groupingBy(HouseOnSaleVillaDto::getDealType));

        for (DealType dealType : dealTypeToHouseOnSaleVillaMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleVillaListRs.setHouseOnSaleVillaMAEMAEList(dealTypeToHouseOnSaleVillaMap.get(dealType));
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleVillaListRs.setHouseOnSaleVillaJEONSEList(dealTypeToHouseOnSaleVillaMap.get(dealType));
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleVillaListRs.setHouseOnSaleVillaWOLSELList(dealTypeToHouseOnSaleVillaMap.get(dealType));
        }

        return houseOnSaleVillaListRs;
    }

    @Override
    public HouseOnSaleVillaDetailRs getHouseOnSaleVillaDetail(Long houseOnSaleVillaId){
        HouseOnSaleVillaDetailRs houseOnSaleVillaDetailRs = new HouseOnSaleVillaDetailRs();

        // 매물정보매핑
        HouseOnSaleVilla houseOnSaleVilla = houseOnSaleVillaRepository.findById(houseOnSaleVillaId)
                .orElseThrow(() -> {
                    throw new NotFoundHouseOnSaleException("해당 ID(" + houseOnSaleVillaId + ")의 매물 정보를 찾을 수 없습니다.");
                });
        houseOnSaleVillaDetailRs.setHouseOnSaleVillaDto(HouseOnSaleVilla.toDto(houseOnSaleVilla));

        // 매물옵션매핑
        HouseOptionVilla houseOptionVilla = houseOptionVillaRepository.findByHouseOnSaleVilla(houseOnSaleVilla);
        if(houseOptionVilla!=null){
            houseOnSaleVillaDetailRs.setHouseOptionVillaDto(HouseOptionVilla.toDto(houseOptionVilla));
        }

        return houseOnSaleVillaDetailRs;
    }
}
