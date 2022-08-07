package com.web.happyhouse.address.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Gugun {
    @Id
    private String gugunCode;        // 구군 코드
    private String gugunName;        // 구군 이름
}
