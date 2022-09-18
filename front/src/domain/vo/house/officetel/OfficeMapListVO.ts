import OfficeMapListRs, { houseInfoDtoList } from 'src/domain/rs/house/officetel/OfficeMapListRs';

export default class OfficeMapListVO {
  data: MapVO[];

  constructor(rs: OfficeMapListRs) {
    this.data = rs.data.map((houseInfoDto) => new MapVO(houseInfoDto));
  }
}

export class MapVO {
  buildYear: string;
  dongCode: number;
  houseInfoId: number;
  houseName: string;
  houseType: 'APT' | 'OFFICETEL' | 'ONEROOM' | 'TWOROOM';
  jiBun: string;
  jibunAddress: string;

  constructor(dto: houseInfoDtoList) {
    this.buildYear = dto.buildYear;
    this.dongCode = Number(dto.dongCode);
    this.houseInfoId = dto.houseInfoId;
    this.houseName = dto.houseName;
    this.houseType = dto.houseType;
    this.jiBun = dto.jiBun;
    this.jibunAddress = dto.jibunAddress;
  }
}
