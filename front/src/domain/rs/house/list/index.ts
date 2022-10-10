import { HouseOnSaleList, HouseInfoDto, CommonReponseType } from 'src/domain/rs/commonTypes';

export interface HouseDetailDataType {
  houseOnSaleJEONSEList: HouseOnSaleList[];
  houseOnSaleMAEMAEList: HouseOnSaleList[];
  houseOnSaleWOLSEList: HouseOnSaleList[];
  houseInfoDto: HouseInfoDto;
}

export interface HouseListRs extends CommonReponseType {
  data: HouseDetailDataType;
}
