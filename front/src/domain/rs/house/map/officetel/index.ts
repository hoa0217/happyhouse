import { ResponseCodeType, HouseType, DongDtoType, InfoDtoType } from 'src/domain/rs/types';

export interface HouseMapOfficetelDataType {
  dongDto: DongDtoType;
  houseInfoDtoList: InfoDtoType;
}

export interface HouseMapOfficetelRs {
  data: HouseMapOfficetelDataType;
  message: string;
  responseCode: ResponseCodeType;
}
