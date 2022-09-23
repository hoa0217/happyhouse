package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseOnSaleVilla;
import com.web.happyhouse.house.entity.HouseOptionVilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOptionVillaRepository extends JpaRepository<HouseOptionVilla, Long> {

    HouseOptionVilla findByHouseOnSaleVilla(HouseOnSaleVilla houseOnSaleVilla);

    void deleteByHouseOnSaleVilla(HouseOnSaleVilla houseOnSaleVilla);

}
