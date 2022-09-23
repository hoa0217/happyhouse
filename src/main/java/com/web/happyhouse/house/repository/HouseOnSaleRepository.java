package com.web.happyhouse.house.repository;

import com.web.happyhouse.house.entity.HouseInfo;
import com.web.happyhouse.house.entity.HouseOnSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseOnSaleRepository extends JpaRepository<HouseOnSale, Long> {

    List<HouseOnSale> findByHouseInfo(HouseInfo houseInfo);

    @Query("select h from HouseOnSale h join fetch h.houseInfo where h.houseOnSaleId = :id")
    HouseOnSale findByHouseOnSaleId(@Param("id") Long houseOnSaleId);

}
