import { HouseInfoDto, HouseType } from 'src/domain/rs/commonTypes';

export class MapVO {
  buildYear: Number;
  dongCode: Number;
  houseInfoId: Number;
  houseName: string;
  houseType: HouseType;
  jibun: string;
  jibueAddress: string;

  constructor(dto: HouseInfoDto) {
    this.buildYear = Number(dto.buildYear);
    this.dongCode = Number(dto.dongCode);
    this.houseInfoId = dto.houseInfoId;
    this.houseName = dto.houseName;
    this.houseType = dto.houseType;
    this.jibun = dto.jibun;
    this.jibueAddress = dto.jibunAddress;
  }
}
