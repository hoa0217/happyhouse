package com.web.happyhouse.address.entity;

import com.web.happyhouse.address.dto.DongDto;
import com.web.happyhouse.address.dto.SidoDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dong {
    @Id
    private String dongCode;        // 동 코드
    private String sidoCode;        // 시도 코드
    private String gugunCode;       // 구군 코드
    private String dongName;        // 동 이름

    /**
     * 동 Entity Builder
     *
     * @param dongCode
     * @param dongName
     */
    @Builder
    private Dong(String dongCode, String sidoCode, String gugunCode, String dongName){
        this.dongCode = dongCode;
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
        this.dongName = dongName;
    }

    /**
     * 동 entity -> dto
     *
     * @param entity
     * @return
     */
    public static DongDto toDto(Dong entity){
        DongDto dto = new DongDto();

        dto.setDongCode(entity.getDongCode());
        dto.setSidoCode(entity.getSidoCode());
        dto.setGugunCode(entity.getGugunCode());
        dto.setDongName(entity.getDongName());

        return dto;
    }

}
