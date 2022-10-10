import { DealType, ResponseCodeType, DirType, HouseType, HouseOnSaleVillaDtoType } from 'src/domain/rs/types';

export interface HouseOptionVillaDtoType {
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
  houseOnSaleVillaDto: HouseOnSaleVillaDtoType;
  houseOptionVillaDto: HouseOptionVillaDtoType;
}

export interface VillaDetailRs {
  data: ViilaDetailDataType;
  message: string;
  responseCode: ResponseCodeType;
}
