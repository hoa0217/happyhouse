package com.web.happyhouse.address.entity;

import com.web.happyhouse.address.dto.GugunDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gugun {
    @Id
    private String gugunCode;        // 구군 코드
    private String sidoCode;         // 시도 코드
    private String gugunName;        // 구군 이름

    /**
     * 구군 Entity Builder
     *
     * @param gugunCode
     * @param gugunName
     */
    @Builder
    private Gugun(String sidoCode, String gugunCode, String gugunName){
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
    }

    /**
     * 구군 entity -> dto
     *
     * @param entity
     * @return
     */
    public static GugunDto toDto(Gugun entity){
        GugunDto dto = new GugunDto();
        dto.setSidoCode(entity.getSidoCode());
        dto.setGugunCode(entity.getGugunCode());
        dto.setGugunName(entity.getGugunName());
        return dto;
    }
}
