package com.web.happyhouse.address.repository;

import com.web.happyhouse.address.entity.Sido;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SidoRepository extends JpaRepository<Sido, Long> {

}
