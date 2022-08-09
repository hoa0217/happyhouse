package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.entity.HouseOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseOptionRepository extends JpaRepository<HouseOption, Long> {

    @Override
    Optional<HouseOption> findById(Long houseOptionId);

    List<HouseOption> findByHouseOnSale(HouseOnSale houseOnSale);

    void deleteByHouseOnSale(HouseOnSale houseOnSale);

}
