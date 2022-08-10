package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseDeal;
import com.web.happyhouse.house.entity.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDealRepository extends JpaRepository<HouseDeal, Long> {

    List<HouseDeal> findByHouseInfo(HouseInfo houseInfo);

}
