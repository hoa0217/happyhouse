import DongListRs, { DongDto } from 'src/domain/rs/adress/DongListRs';

export default class DongListVO {
  dongDtoList: DongVO[];

  constructor(rs: DongListRs) {
    this.dongDtoList = rs.data.map((dongDto) => new DongVO(dongDto));
  }
}

export class DongVO {
  dongCode: number;
  dongName: string;
  gugunCode: string;
  sidoCode: string;

  constructor(dto: DongDto) {
    this.dongCode = Number(dto.dongCode);
    this.dongName = dto.dongName;
    this.gugunCode = dto.gugunCode;
    this.sidoCode = dto.sidoCode;
  }
}
