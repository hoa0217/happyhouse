import { DealDataType, DealType, DirType, InfoDtoType, ResponseCodeType } from 'src/domain/rs/types';

export interface HouseOnSaleType {
  bathCount: string;
  contractArea: number;
  createdBy: string;
  createdTime: string;
  dealType: DealType;
  dirType: DirType;
  dongCode: string;
  floor: string;
  houseInfoId: number;
  houseOnSaleId: number;
  mngFee: number;
  movingDate: string;
  netLeasableArea: number;
  parkCount: string;
  price: number;
  rent: number;
  roomCount: string;
  totalFloor: string;
  updateBy: string;
  updatedTime: Date;
}

export interface HouseOptionDtoType {
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
  houseDealJEONSEList: DealDataType;
  houseDealMAEMAEList: DealDataType;
  houseDealWOLSEList: DealDataType;
  houseInfoDto: InfoDtoType;
  houseOnSaleDto: HouseOnSaleType;
  houseOptionDto: HouseOptionDtoType;
}

export interface HouseDetailRs {
  data: HouseDetailDataType;
  message: string;
  responseCode: ResponseCodeType;
}
