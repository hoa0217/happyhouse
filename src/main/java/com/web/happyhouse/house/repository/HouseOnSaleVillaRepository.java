package com.web.happyhouse.house.repository;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.entity.HouseOnSaleVilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseOnSaleVillaRepository extends JpaRepository<HouseOnSaleVilla, Long> {

    List<HouseOnSaleVilla> findByDongAndHouseType(Dong dong, HouseType houseType);

    List<HouseOnSaleVilla> findByZoneCodeAndHouseType(String zoneCode, HouseType houseType);

}
