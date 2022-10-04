import MapListRs, { houseInfoDto } from 'src/domain/rs/house/apt/MapListRs';

export default class MapListVO {
  houseInfoDtoList: MapVO[];

  constructor(rs: MapListRs) {
    this.houseInfoDtoList = rs.data.houseInfoDtoList.map((houseInfoDto) => new MapVO(houseInfoDto));
  }
}

export class MapVO {
  buildYear: Number;
  dongCode: Number;
  houseInfoId: Number;
  houseName: string;
  houseType: string;
  jibun: string;
  jibueAddress: string;

  constructor(dto: houseInfoDto) {
    this.buildYear = Number(dto.buildYear);
    this.dongCode = Number(dto.dongCode);
    this.houseInfoId = dto.houseInfoId;
    this.houseName = dto.houseName;
    this.houseType = dto.houseType;
    this.jibun = dto.jibun;
    this.jibueAddress = dto.jibunAddress;
  }
}
