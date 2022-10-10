import { DongDto, HouseInfoDto, CommonReponseType } from 'src/domain/rs/commonTypes';

export interface HouseMapOfficetelDataType {
  dongDto: DongDto;
  houseInfoDtoList: HouseInfoDto[];
}

export interface HouseMapOfficetelRs extends CommonReponseType {
  data: HouseMapOfficetelDataType;
}
