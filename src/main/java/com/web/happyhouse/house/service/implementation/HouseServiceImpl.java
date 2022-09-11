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
    public HouseInfoListRs searchHouseInfoList(String dongCode, HouseType houseType) {
        HouseInfoListRs houseInfoListRs = new HouseInfoListRs();
        Dong dong = dongRepository.findByDongCode(dongCode);
        List<HouseInfoDto> houseInfoDtoList = houseInfoRepository.findByDongAndHouseType(dong, houseType)
                .stream()
                .map(entity -> HouseInfo.toDto(entity))
                .collect(Collectors.toList());
        houseInfoListRs.setHouseInfoDtoList(houseInfoDtoList);

        return houseInfoListRs;
    }

    @Override
    public HouseOnSaleVillaMapRs searchHouseOnSaleList(String dongCode, HouseType houseType) {
        HouseOnSaleVillaMapRs houseOnSaleVillaMapRs = new HouseOnSaleVillaMapRs();
        Dong dong = dongRepository.findByDongCode(dongCode);

        Map<String, Long> zoneCodeToCountingMap = houseOnSaleVillaRepository.findByDongAndHouseType(dong, houseType)
                .stream()
                .collect(Collectors.groupingBy(HouseOnSaleVilla::getZoneCode, Collectors.counting()));

        houseOnSaleVillaMapRs.setDongCode(dongCode);
        houseOnSaleVillaMapRs.setHouseType(houseType);
        houseOnSaleVillaMapRs.setZoneCodeToCountingMap(zoneCodeToCountingMap);

        return houseOnSaleVillaMapRs;
    }

    @Override
    public HouseOnSaleListRs getHouseOnSale(Long houseInfoId) {
        HouseOnSaleListRs houseOnSaleListRs = new HouseOnSaleListRs();

        // 집정보 매핑
        HouseInfo houseInfo = houseInfoRepository.findById(houseInfoId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseInfoId + ")의 집 정보를 찾을 수 없습니다.");
                });
        houseOnSaleListRs.setHouseInfoDto(HouseInfo.toDto(houseInfo));

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
        houseOnSaleListRs.setHouseOnSaleMAEMAEList(houseOnSaleMAEMAEList);
        houseOnSaleListRs.setHouseOnSaleJEONSEList(houseOnSaleJEONSEList);
        houseOnSaleListRs.setHouseOnSaleWOLSEList(houseOnSaleWOLSEList);

        return houseOnSaleListRs;
    }

    @Override
    public HouseOnSaleVillaListRs getHouseOnSaleVilla(String zoneCode, HouseType houseType) {

        HouseOnSaleVillaListRs houseOnSaleVillaListRs = new HouseOnSaleVillaListRs();
        houseOnSaleVillaListRs.setZoneCode(zoneCode);
        houseOnSaleVillaListRs.setHouseType(houseType);

        // 매물정보매핑
        Map<DealType, List<HouseOnSaleVillaDto>> dealTypeToHouseOnSaleVillaMap = houseOnSaleVillaRepository.findByZoneCodeAndHouseType(zoneCode, houseType)
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
    public HouseOnSaleDetailRs getHouseOnSaleDetail(Long houseOnSaleId) {

        HouseOnSaleDetailRs houseOnSaleDetailRs = new HouseOnSaleDetailRs();

        // 매물정보매핑
        HouseOnSale houseOnSale = houseOnSaleRepository.findById(houseOnSaleId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseOnSaleId + ")의 매물 정보를 찾을 수 없습니다.");
                });

        houseOnSaleDetailRs.setHouseOnSaleDto(HouseOnSale.toDto(houseOnSale));

        // 집정보매핑
        houseOnSaleDetailRs.setHouseInfoDto(HouseInfo.toDto(houseOnSale.getHouseInfo()));

        // 매물옵션매핑
        HouseOption houseOption = houseOptionRepository.findByHouseOnSale(houseOnSale).get(0);
        houseOnSaleDetailRs.setHouseOptionDto(HouseOption.toDto(houseOption));

        // 집거래내역매핑
        Map<DealType, List<HouseDealDto>> dealTypeToHouseDealMap = houseDealRepository.findByHouseInfo(houseOnSale.getHouseInfo())
                .stream()
                .map(entity -> HouseDeal.toDto(entity))
                .collect(Collectors.groupingBy(HouseDealDto::getDealType));

        for (DealType dealType : dealTypeToHouseDealMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleDetailRs.setHouseDealMAEMAEList(dealTypeToHouseDealMap.get(dealType));
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleDetailRs.setHouseDealJEONSEList(dealTypeToHouseDealMap.get(dealType));
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleDetailRs.setHouseDealWOLSEList(dealTypeToHouseDealMap.get(dealType));
        }

        return houseOnSaleDetailRs;
    }

    @Override
    public HouseOnSaleVillaDetailRs getHouseOnSaleVillaDetail(Long houseOnSaleVillaId){
        HouseOnSaleVillaDetailRs houseOnSaleVillaDetailRs = new HouseOnSaleVillaDetailRs();

        // 매물정보매핑
        HouseOnSaleVilla houseOnSaleVilla = houseOnSaleVillaRepository.findById(houseOnSaleVillaId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 ID(" + houseOnSaleVillaId + ")의 매물 정보를 찾을 수 없습니다.");
                });
        houseOnSaleVillaDetailRs.setHouseOnSaleVillaDto(HouseOnSaleVilla.toDto(houseOnSaleVilla));

        // 매물옵션매핑
        HouseOptionVilla houseOptionVilla = houseOptionVillaRepository.findByHouseOnSaleVilla(houseOnSaleVilla).get(0);
        houseOnSaleVillaDetailRs.setHouseOptionVillaDto(HouseOptionVilla.toDto(houseOptionVilla));

        return houseOnSaleVillaDetailRs;
    }
}
