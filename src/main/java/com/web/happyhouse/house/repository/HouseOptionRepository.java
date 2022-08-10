package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseOptionRepository extends JpaRepository<HouseOption, Long> {

    List<HouseOption> findByHouseOnSale(HouseOnSale houseOnSale);

    void deleteByHouseOnSale(HouseOnSale houseOnSale);

}
