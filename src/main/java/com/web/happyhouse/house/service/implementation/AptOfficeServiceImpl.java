package com.web.happyhouse.house.service.implementation;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.advice.exception.NotFoundHouseInfoException;
import com.web.happyhouse.advice.exception.NotFoundHouseOnSaleException;
import com.web.happyhouse.advice.exception.NotFoundHouseOptionException;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.*;
import com.web.happyhouse.house.dto.response.HouseInfoListRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleDetailRs;
import com.web.happyhouse.house.dto.response.HouseOnSaleListRs;
import com.web.happyhouse.house.dto.createRequest.HouseOnSaleCreateRq;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateDto;
import com.web.happyhouse.house.dto.updateRequest.HouseOnSaleUpdateRq;
import com.web.happyhouse.house.dto.updateRequest.HouseOptionUpdateDto;
import com.web.happyhouse.house.entity.*;
import com.web.happyhouse.house.repository.HouseDealRepository;
import com.web.happyhouse.house.repository.HouseInfoRepository;
import com.web.happyhouse.house.repository.HouseOnSaleRepository;
import com.web.happyhouse.house.repository.HouseOptionRepository;
import com.web.happyhouse.house.service.AptOfficeService;
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
public class AptOfficeServiceImpl implements AptOfficeService {

    private final DongRepository dongRepository;
    private final HouseInfoRepository houseInfoRepository;
    private final HouseDealRepository houseDealRepository;
    private final HouseOnSaleRepository houseOnSaleRepository;
    private final HouseOptionRepository houseOptionRepository;

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
    public HouseOnSaleListRs getHouseOnSale(Long houseInfoId) {
        HouseOnSaleListRs houseOnSaleListRs = new HouseOnSaleListRs();

        // 집정보 매핑
        HouseInfo houseInfo = houseInfoRepository.findById(houseInfoId)
                .orElseThrow(() -> {
                    throw new NotFoundHouseInfoException("해당 ID(" + houseInfoId + ")의 집 정보를 찾을 수 없습니다.");
                });
        houseOnSaleListRs.setHouseInfoDto(HouseInfo.toDto(houseInfo));

        // 매물정보 매핑
        Map<DealType, List<HouseOnSaleDto>> dealTypeToHouseOnSaleMap = houseOnSaleRepository.findByHouseInfo(houseInfo)
                .stream()
                .map(entity -> HouseOnSale.toDto(entity))
                .collect(Collectors.groupingBy(HouseOnSaleDto::getDealType));

        for (DealType dealType : dealTypeToHouseOnSaleMap.keySet()) {
            if (dealType.equals(DealType.MAEMAE))
                houseOnSaleListRs.setHouseOnSaleMAEMAEList(dealTypeToHouseOnSaleMap.get(dealType));
            else if (dealType.equals(DealType.JEONSE))
                houseOnSaleListRs.setHouseOnSaleJEONSEList(dealTypeToHouseOnSaleMap.get(dealType));
            else if (dealType.equals(DealType.WOLSE))
                houseOnSaleListRs.setHouseOnSaleWOLSEList(dealTypeToHouseOnSaleMap.get(dealType));
        }

        return houseOnSaleListRs;
    }

    @Override
    public HouseOnSaleDetailRs getHouseOnSaleDetail(Long houseOnSaleId) {

        HouseOnSaleDetailRs houseOnSaleDetailRs = new HouseOnSaleDetailRs();

        // 매물정보매핑
        HouseOnSale houseOnSale = houseOnSaleRepository.findByHouseOnSaleId(houseOnSaleId);
        if(houseOnSale == null){
            throw new NotFoundHouseOnSaleException("해당 ID(" + houseOnSaleId + ")의 매물 정보를 찾을 수 없습니다.");
        }
        houseOnSaleDetailRs.setHouseOnSaleDto(HouseOnSale.toDto(houseOnSale));

        // 집정보매핑
        houseOnSaleDetailRs.setHouseInfoDto(HouseInfo.toDto(houseOnSale.getHouseInfo()));

        // 매물옵션매핑
        HouseOption houseOption = houseOptionRepository.findByHouseOnSale(houseOnSale);
        if(houseOption == null){
            throw new NotFoundHouseOptionException("해당 매물(" + houseOnSaleId + ")의 옵션 정보를 찾을 수 없습니다.");
        }
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
    @Transactional
    public Long saveHouseOnSale(HouseOnSaleCreateRq createRq) {
        HouseInfo houseInfo = houseInfoRepository.findById(createRq.getHouseInfoId())
                .orElseThrow(() -> {
                    throw new NotFoundHouseInfoException("해당 ID(" + createRq.getHouseInfoId() + ")의 매물 정보를 찾을 수 없습니다.");
                });

        // 매물정보 저장
        HouseOnSale houseOnSale = createRq.getHouseOnSaleCreateDto().toEntity(houseInfo);
        HouseOnSale saved = houseOnSaleRepository.save(houseOnSale);

        // 옵션정보 저장
        HouseOption houseOption = createRq.getHouseOptionCreateDto().toEntity(saved);
        houseOptionRepository.save(houseOption);

        return saved.getHouseOnSaleId();
    }

    @Override
    @Transactional
    public Long updateHouseOnSale(HouseOnSaleUpdateRq updateRq) {
        // 매물정보 업데이트
        HouseOnSaleUpdateDto updateDto = updateRq.getHouseOnSaleUpdateDto();
        HouseOnSale houseOnSale = houseOnSaleRepository.findById(updateDto.getHouseOnSaleId())
                .orElseThrow(() -> {
                    throw new NotFoundHouseOnSaleException("해당 ID(" + updateDto.getHouseOnSaleId() + ")의 매물 정보를 찾을 수 없습니다.");
                });
        houseOnSale.update(updateDto);

        // 옵션정보 업데이트
        HouseOptionUpdateDto optionUpdateDto = updateRq.getHouseOptionUpdateDto();
        HouseOption houseOption = houseOptionRepository.findByHouseOnSale(houseOnSale);
        if(houseOption == null){
            throw new NotFoundHouseOptionException("해당 매물(" + houseOnSale.getHouseOnSaleId() + ")의 옵션 정보를 찾을 수 없습니다.");
        }
        houseOption.update(optionUpdateDto);

        return houseOnSale.getHouseOnSaleId();
    }

    @Override
    @Transactional
    public void deleteHouseOnSale(Long houseOnSaleId) {
        HouseOnSale houseOnSale = houseOnSaleRepository.findById(houseOnSaleId)
                .orElseThrow(() -> {
                    throw new NotFoundHouseOnSaleException("해당 ID(" + houseOnSaleId + ")의 매물 정보를 찾을 수 없습니다.");
                });

        // 옵션정보 삭제
        houseOptionRepository.deleteByHouseOnSale(houseOnSale);
        // 매물정보 삭제
        houseOnSaleRepository.delete(houseOnSale);
    }
}
