package com.web.happyhouse.address.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Sido {
    @Id
    private String sidoCode;        // 시 코드
    private String sidoName;        // 시 이름
}

