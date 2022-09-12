export type DealTypeRs = 'JEONSE' | 'MAEMAE' | 'WOLSE';
export type IdRs = string | number;
export type ResponseCodeType =
  | 'BAD_REQUEST'
  | 'CONFLICT'
  | 'CREATED'
  | 'DB_ERROR'
  | 'FORBIDDEN'
  | 'INTERNAL_SERVER_ERROR'
  | 'NOT_FOUND'
  | 'NO_CONTENT'
  | 'OK'
  | 'SERVICE_UNAVAILABLE'
  | 'UNAUTHORIZED';

export type houseDealDto = {
  area: number;
  dealDay: string;
  dealMonth: string;
  dealType: DealTypeRs;
  dealYear: string;
  floor: string;
  houseDealId: number;
  houseInfoId: IdRs;
  price: number;
  rent: number;
};

export type houseInfoDto = {
  buildYear: string;
  dongCode: string;
  houseInfoId: IdRs;
  houseName: string;
  houseType: string;
  jiBun: string;
  jibunAddress: string;
};

export type houseOnSaleDto = {
  bathCount: string;
  contractArea: number;
  createdBy: string | null;
  createdTime: Date | null;
  dealType: DealTypeRs;
  dirType: string;
  dongCode: string;
  floor: string;
  houseInfoId: IdRs;
  houseOnSaleId: IdRs;
  mngFee: number;
  movingDate: string;
  netLeasableArea: number;
  parkCount: string;
  price: number;
  rent: number;
  roomCount: string;
  totalFloor: string;
  updatedBy: string | null;
  updatedTime: Date | null;
};

export type houseOptionDto = {
  airConditionerYn: boolean;
  bedYn: boolean;
  centerBoilYn: boolean;
  closetYn: boolean;
  electricYn: boolean;
  elevatorYn: boolean;
  gasStoveYn: boolean;
  gasYn: boolean;
  houseOnSaleId: IdRs;
  houseOptionId: IdRs;
  inductionYn: boolean;
  internetYn: boolean;
  laundryYn: boolean;
  localBoilYn: boolean;
  microwaveYn: boolean;
  personalBoilYn: boolean;
  rfgYn: boolean;
  tvConnectYn: boolean;
  tvYn: boolean;
  waterYn: boolean;
};

export type HouseDetailDataRs = {
  houseDealJEONSEList: houseDealDto[];
  houseDealMAEMAEList: houseDealDto[];
  houseDealWOLSEList: houseDealDto[];
  houseInfoDto: houseInfoDto;
  houseOnSaleDto: houseOnSaleDto;
  houseOptionDto: houseOptionDto;
};

export interface HouseDetailRs {
  data: HouseDetailDataRs;
  message: string;
  responseCode: ResponseCodeType;
}
