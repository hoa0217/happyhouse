package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOptionRepository extends JpaRepository<HouseOption, Long> {

    HouseOption findByHouseOnSale(HouseOnSale houseOnSale);

    void deleteByHouseOnSale(HouseOnSale houseOnSale);

}
