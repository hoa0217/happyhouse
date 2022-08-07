package com.web.happyhouse.address.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Dong {
    @Id
    private String dongCode;        // 동 코드
    private String dongName;        // 동 이름

}
