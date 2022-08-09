package com.web.happyhouse.house.repository;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.entity.HouseDeal;
import com.web.happyhouse.house.entity.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseInfoRepository extends JpaRepository<HouseInfo, Long> {

    List<HouseInfo> findByDongAndHouseType(Dong dong, HouseType houseType);

}
