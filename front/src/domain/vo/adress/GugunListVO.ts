import GugunListRs, { GugunDto } from "src/domain/rs/adress/GugunListRs";

export default class GugunListVO {
    gugunDtoList : GugunVO[];

    constructor(rs: GugunListRs) {
        this.gugunDtoList = rs.data.map((gugunDto) => new GugunVO(gugunDto));
    }
}

export class GugunVO {
    gugunCode : Number;
    gugunName : string;
    sidoCode : string;

    constructor(dto: GugunDto){
        this.gugunCode = Number(dto.gugunCode);
        this.gugunName = dto.gugunName;
        this.sidoCode = dto.sidoCode;
    }
}