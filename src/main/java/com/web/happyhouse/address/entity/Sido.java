package com.web.happyhouse.address.entity;

import com.web.happyhouse.address.dto.SidoDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sido {
    @Id
    private String sidoCode;        // 시 코드
    private String sidoName;        // 시 이름

    /**
     * 시도 Entity Builder
     *
     * @param sidoCode
     * @param sidoName
     */
    @Builder
    private Sido(String sidoCode, String sidoName){
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
    }

    /**
     * 시도 entity -> dto
     *
     * @param entity
     * @return
     */
    public static SidoDto toDto(Sido entity){
        SidoDto dto = new SidoDto();
        dto.setSidoCode(entity.getSidoCode());
        dto.setSidoName(entity.getSidoName());

        return dto;
    }

}

