import { HouseDealList, HouseOnSaleList, HouseInfoDto, CommonReponseType } from 'src/domain/rs/commonTypes';

export interface HouseOptionDto {
  airConditionerYn: boolean;
  bedYn: boolean;
  centerBoilYn: boolean;
  closetYn: boolean;
  createdTime: Date;
  electricYn: boolean;
  elevatorYn: boolean;
  gasStoveYn: boolean;
  gasYn: boolean;
  houseOnSaleId: number;
  houseOptionId: number;
  inductionYn: boolean;
  internetYn: boolean;
  laundryYn: boolean;
  localBoilYn: boolean;
  microwaveYn: boolean;
  personalBoilYn: boolean;
  rfgYn: boolean;
  tvConnectYn: boolean;
  tvYn: boolean;
  updatedTime: Date;
  waterYn: boolean;
}

export interface HouseDetailDataType {
  houseDealJEONSEList: HouseDealList[];
  houseDealMAEMAEList: HouseDealList[];
  houseDealWOLSEList: HouseDealList[];
  houseInfoDto: HouseInfoDto;
  houseOnSaleDto: HouseOnSaleList;
  houseOptionDto: HouseOptionDto;
}

export interface HouseDetailRs extends CommonReponseType {
  data: HouseDetailDataType;
}
