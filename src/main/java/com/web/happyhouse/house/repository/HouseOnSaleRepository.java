package com.web.happyhouse.house.repository;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.house.domain.DealType;
import com.web.happyhouse.house.entity.HouseInfo;
import com.web.happyhouse.house.entity.HouseOnSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseOnSaleRepository extends JpaRepository<HouseOnSale, Long> {

    @Override
    Optional<HouseOnSale> findById(Long houseOnSaleId);

    List<HouseOnSale> findByHouseInfo(HouseInfo houseInfo);

    List<HouseOnSale> findByHouseInfoAndDealTypeIn(HouseInfo houseInfo, List<DealType> dealTypeList);

    List<HouseOnSale> findByDongCode(Dong dongCode);

    List<HouseOnSale> findByDongCodeAndDealTypeIn(Dong dongCode, List<DealType> dealTypeList);

}
