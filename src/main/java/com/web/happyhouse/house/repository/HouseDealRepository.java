package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.entity.HouseDeal;
import com.web.happyhouse.house.entity.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseDealRepository extends JpaRepository<HouseDeal, Long> {

    @Override
    Optional<HouseDeal> findById(Long houseDealId);

    List<HouseDeal> findByHouseInfo(HouseInfo houseInfo);

    List<HouseDeal> findByHouseInfoAndDealTypeIn(HouseInfo houseInfo, List<DealType> dealTypeList);

}
