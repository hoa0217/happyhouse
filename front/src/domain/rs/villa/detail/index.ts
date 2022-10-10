import { HouseOnSaleVillaDto, CommonReponseType } from 'src/domain/rs/commonTypes';

export interface HouseOptionVillaDto {
  airConditionerYn: boolean;
  bedYn: boolean;
  centerBoilYn: boolean;
  closetYn: boolean;
  createdTime: Date;
  electricYn: boolean;
  elevatorYn: boolean;
  gasStoveYn: boolean;
  gasYn: boolean;
  houseOnSaleVillaId: number;
  houseOptionVillaId: number;
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

export interface ViilaDetailDataType {
  houseOnSaleVillaDto: HouseOnSaleVillaDto;
  houseOptionVillaDto: HouseOptionVillaDto;
}

export interface VillaDetailRs extends CommonReponseType {
  data: ViilaDetailDataType;
}
