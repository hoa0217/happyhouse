import { ResponseCodeType, DongDto, HouseInfoDto } from 'src/domain/rs/commonTypes';

export interface HouseMapOfficetelDataType {
  dongDto: DongDto;
  houseInfoDtoList: HouseInfoDto[];
}

export interface HouseMapOfficetelRs {
  data: HouseMapOfficetelDataType;
  message: string;
  responseCode: ResponseCodeType;
}
