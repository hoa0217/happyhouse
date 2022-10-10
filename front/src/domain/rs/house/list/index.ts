import { DealDataType, DealType, InfoDtoType, ResponseCodeType } from 'src/domain/rs/types';

export interface HouseDetailDataType {
  houseDealJEONSEList: DealDataType;
  houseDealMAEMAEList: DealDataType;
  houseDealWOLSEList: DealDataType;
  houseInfoDto: InfoDtoType;
}

export interface HouseListRs {
  data: HouseDetailDataType;
  message: string;
  responseCode: ResponseCodeType;
}
