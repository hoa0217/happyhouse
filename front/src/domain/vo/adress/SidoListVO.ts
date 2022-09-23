import SidoListRs, { SidoDto } from "src/domain/rs/adress/SidoListRs";

export default class SidoListVO {
    sidoDtoList : SidoVO[];

    constructor(rs: SidoListRs){
        this.sidoDtoList = rs.data.map((sidoDto)=> new SidoVO(sidoDto));
    }
}

export class SidoVO {
    sidoCode : Number;
    sidoName : string;

    constructor(dto: SidoDto){
        this.sidoCode = Number(dto.sidoCode);
        this.sidoName = dto.sidoName;
    }
}