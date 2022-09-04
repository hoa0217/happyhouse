export type houseDealDtoType = {
  area: number;
  dealDay: string;
  dealMonth: string;
  dealType: string;
  dealYear: string;
  floor: string;
  houseDealId: number;
  houseInfoId: number;
  price: number;
  rent: number;
};

export type houseInfoDtoType = {
  buildYear: string;
  dongCode: string;
  houseInfoId: number;
  houseName: string;
  houseType: string;
  jiBun: string;
  jibunAddress: string;
};

export type houseOnSaleDtoType = {
  bathCount: string;
  contractArea: number;
  createdBy: string | null;
  createdTime: Date | null;
  dealType: string;
  dirType: string;
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
  waterYn: boolean;
};

export interface HouseInfoDtoType {
  houseDealJEONSEList: houseDealDtoType[];
  houseDealMAEMAEList: houseDealDtoType[];
  houseDealWOLSEList: houseDealDtoType[];
  houseInfoDto: houseInfoDtoType;
  houseOnSaleDto: houseOnSaleDtoType;
  houseOptionDto: houseOptionDto;
}
