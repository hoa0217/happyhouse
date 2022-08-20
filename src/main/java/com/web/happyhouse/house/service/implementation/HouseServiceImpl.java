package com.web.happyhouse.house.service.implementation;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;
import com.web.happyhouse.house.entity.*;
import com.web.happyhouse.house.repository.*;
import com.web.happyhouse.house.service.HouseService;
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
public class HouseServiceImpl implements HouseService {

    private final DongRepository dongRepository;
    private final HouseInfoRepository houseInfoRepository;
    private final HouseDealRepository houseDealRepository;
    private final HouseOnSaleRepository houseOnSaleRepository;
    private final HouseOptionRepository houseOptionRepository;
    private final HouseOnSaleVillaRepository houseOnSaleVillaRepository;
    private final HouseOptionVillaRepository houseOptionVillaRepository;

    @Override
    public HouseInfoListDto searchHouseInfoList(String dongCode, HouseType houseType) {
        HouseInfoListDto houseInfoListDto = new HouseInfoListDto();
        Dong dong = dongRepository.findByDongCode(dongCode);
        List<HouseInfoDto> houseInfoDtoList = houseInfoRepository.findByDongAndHouseType(dong, houseType)
                .stream()
                .map(entity -> HouseInfo.toDto(entity))
                .collect(Collectors.toList());
        houseInfoListDto.setHouseInfoDtoList(houseInfoDtoList);

        return houseInfoListDto;
    }

    @Override
    public HouseOnSaleVillaMapDto searchHouseOnSaleList(String dongCode, HouseType houseType) {
        HouseOnSaleVillaMapDto houseOnSaleVillaMapDto = new HouseOnSaleVillaMapDto();
        Dong dong = dongRepository.findByDongCode(dongCode);

        Map<String, Long> zoneCodeToCountingMap = houseOnSaleVillaRepository.findByDongAndHouseType(dong, houseType)
                .stream()
                .collect(Collectors.groupingBy(HouseOnSaleVilla::getZoneCode, Collectors.counting()));

        houseOnSaleVillaMapDto.setDongCode(dongCode);
        houseOnSaleVillaMapDto.setHouseType(houseType);
        houseOnSaleVillaMapDto.setZoneCodeToCountingMap(zoneCodeToCountingMap);

        return houseOnSaleVillaMapDto;
    }

    @Override
    public HouseOnSaleListDto getHouseOnSale(Long houseInfoId) {
        HouseOnSaleListDto houseOnSaleListDto = new HouseOnSaleListDto();

        // 집정보 매핑
        HouseInfo houseInfo = houseInfoRepository.findById(houseInfoId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseInfoId + ")의 집 정보를 찾을 수 없습니다.");
                });
        houseOnSaleListDto.setHouseInfoDto(HouseInfo.toDto(houseInfo));

        // 매물정보매핑
        Map<DealType, List<HouseOnSaleDto>> dealTypeToHouseOnSaleMap = houseOnSaleRepository.findByHouseInfo(houseInfo)
                .stream()
                .map(entity -> HouseOnSale.toDto(entity))
                .collect(Collectors.groupingBy(HouseOnSaleDto::getDealType));

        List<HouseOnSaleDto> houseOnSaleMAEMAEList = new ArrayList<>();
        List<HouseOnSaleDto> houseOnSaleJEONSEList = new ArrayList<>();
        List<HouseOnSaleDto> houseOnSaleWOLSEList = new ArrayList<>();
        for (DealType dealType : dealTypeToHouseOnSaleMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleMAEMAEList = dealTypeToHouseOnSaleMap.get(dealType);
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleJEONSEList = dealTypeToHouseOnSaleMap.get(dealType);
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleWOLSEList = dealTypeToHouseOnSaleMap.get(dealType);
        }
        houseOnSaleListDto.setHouseOnSaleMAEMAEList(houseOnSaleMAEMAEList);
        houseOnSaleListDto.setHouseOnSaleJEONSEList(houseOnSaleJEONSEList);
        houseOnSaleListDto.setHouseOnSaleWOLSEList(houseOnSaleWOLSEList);

        return houseOnSaleListDto;
    }

    @Override
    public HouseOnSaleVillaListDto getHouseOnSaleVilla(String zoneCode, HouseType houseType) {

        HouseOnSaleVillaListDto houseOnSaleVillaListDto = new HouseOnSaleVillaListDto();
        houseOnSaleVillaListDto.setZoneCode(zoneCode);
        houseOnSaleVillaListDto.setHouseType(houseType);

        // 매물정보매핑
        Map<DealType, List<HouseOnSaleVillaDto>> dealTypeToHouseOnSaleVillaMap = houseOnSaleVillaRepository.findByZoneCodeAndHouseType(zoneCode, houseType)
                .stream()
                .map(entity -> HouseOnSaleVilla.toDto(entity))
                .collect(Collectors.groupingBy(HouseOnSaleVillaDto::getDealType));

        for (DealType dealType : dealTypeToHouseOnSaleVillaMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleVillaListDto.setHouseOnSaleVillaMAEMAEList(dealTypeToHouseOnSaleVillaMap.get(dealType));
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleVillaListDto.setHouseOnSaleVillaJEONSEList(dealTypeToHouseOnSaleVillaMap.get(dealType));
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleVillaListDto.setHouseOnSaleVillaWOLSELList(dealTypeToHouseOnSaleVillaMap.get(dealType));
        }

        return houseOnSaleVillaListDto;
    }

    @Override
    public HouseOnSaleDetailDto getHouseOnSaleDetail(Long houseOnSaleId) {

        HouseOnSaleDetailDto houseOnSaleDetailDto = new HouseOnSaleDetailDto();

        // 매물정보매핑
        HouseOnSale houseOnSale = houseOnSaleRepository.findById(houseOnSaleId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseOnSaleId + ")의 매물 정보를 찾을 수 없습니다.");
                });

        houseOnSaleDetailDto.setHouseOnSaleDto(HouseOnSale.toDto(houseOnSale));

        // 집정보매핑
        houseOnSaleDetailDto.setHouseInfoDto(HouseInfo.toDto(houseOnSale.getHouseInfo()));

        // 매물옵션매핑
        HouseOption houseOption = houseOptionRepository.findByHouseOnSale(houseOnSale).get(0);
        houseOnSaleDetailDto.setHouseOptionDto(HouseOption.toDto(houseOption));

        // 집거래내역매핑
        Map<DealType, List<HouseDealDto>> dealTypeToHouseDealMap = houseDealRepository.findByHouseInfo(houseOnSale.getHouseInfo())
                .stream()
                .map(entity -> HouseDeal.toDto(entity))
                .collect(Collectors.groupingBy(HouseDealDto::getDealType));

        for (DealType dealType : dealTypeToHouseDealMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleDetailDto.setHouseDealMAEMAEList(dealTypeToHouseDealMap.get(dealType));
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleDetailDto.setHouseDealJEONSEList(dealTypeToHouseDealMap.get(dealType));
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleDetailDto.setHouseDealWOLSEList(dealTypeToHouseDealMap.get(dealType));
        }

        return houseOnSaleDetailDto;
    }

    @Override
    public HouseOnSaleVillaDetailDto getHouseOnSaleVillaDetail(Long houseOnSaleVillaId){
        HouseOnSaleVillaDetailDto houseOnSaleVillaDetailDto = new HouseOnSaleVillaDetailDto();

        // 매물정보매핑
        HouseOnSaleVilla houseOnSaleVilla = houseOnSaleVillaRepository.findById(houseOnSaleVillaId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseOnSaleVillaId + ")의 매물 정보를 찾을 수 없습니다.");
                });
        houseOnSaleVillaDetailDto.setHouseOnSaleVillaDto(HouseOnSaleVilla.toDto(houseOnSaleVilla));

        // 매물옵션매핑
        HouseOptionVilla houseOptionVilla = houseOptionVillaRepository.findByHouseOnSaleVilla(houseOnSaleVilla).get(0);
        houseOnSaleVillaDetailDto.setHouseOptionVillaDto(HouseOptionVilla.toDto(houseOptionVilla));

        return houseOnSaleVillaDetailDto;
    }
}
