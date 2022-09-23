package com.web.happyhouse.address.service.implementation;

import com.web.happyhouse.address.dto.DongDto;
import com.web.happyhouse.address.dto.GugunDto;
import com.web.happyhouse.address.dto.SidoDto;
import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.entity.Gugun;
import com.web.happyhouse.address.entity.Sido;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.address.repository.GugunRepository;
import com.web.happyhouse.address.repository.SidoRepository;
import com.web.happyhouse.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final SidoRepository sidoRepository;
    private final GugunRepository gugunRepository;
    private final DongRepository dongRepository;

    @Override
    public List<SidoDto> searchSidoList() {

        return sidoRepository.findAll(Sort.by(Sort.Direction.DESC, "sidoCode"))
                .stream()
                .map(entity -> Sido.toDto(entity))
                .collect(Collectors.toList());

    }

    @Override
    public List<GugunDto> searchGugunList(String sidoCode) {
        return gugunRepository.findBySidoCode(sidoCode)
                .stream()
                .map(entity -> Gugun.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<DongDto> searchDongList(String sidoCode, String gugunCode) {
        return dongRepository.findBySidoCodeAndGugunCode(sidoCode, gugunCode)
                .stream()
                .map(entity -> Dong.toDto(entity))
                .collect(Collectors.toList());
    }
}
