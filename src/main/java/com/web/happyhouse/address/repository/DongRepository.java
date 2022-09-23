package com.web.happyhouse.address.repository;

import com.web.happyhouse.address.entity.Dong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DongRepository extends JpaRepository<Dong, Long> {

    List<Dong> findBySidoCodeAndGugunCode(String sidoCode, String gugunCode);
    Dong findByDongCode(String dongCode);

}
