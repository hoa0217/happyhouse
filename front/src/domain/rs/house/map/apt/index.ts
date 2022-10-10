import { HouseInfoDto, DongDto, CommonReponseType } from 'src/domain/rs/commonTypes';

export interface HouseMapAptDataType {
  dongDto: DongDto;
  houseInfoDtoList: HouseInfoDto[];
}

export interface HouseMapAptRs extends CommonReponseType {
  data: HouseMapAptDataType;
}
