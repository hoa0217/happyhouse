import { ResponseCodeType, InfoDtoType, DongDtoType } from 'src/domain/rs/types';

export interface HouseMapAptDataType {
  dongDto: DongDtoType;
  houseInfoDtoList: InfoDtoType;
}

export interface HouseMapAptRs {
  data: HouseMapAptDataType;
  message: string;
  responseCode: ResponseCodeType;
}
