// CommonTypes
export type DealType = 'MAEMAE' | 'JEONSE' | 'WOLSE';
export type DirType = 'EAST' | 'NORTH' | 'NORTHEAST' | 'NORTHWEST' | 'SOUTH' | 'SOUTHEAST' | 'SOUTHWEST' | 'WEST';
export type HouseType = 'APT' | 'OFFICETEL' | 'ONEROOM' | 'TWOROOM';
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

export interface CommonReponseType {
  message: string;
  responseCode: ResponseCodeType;
}

// APT & OFFICETEL CommonTypes
export interface HouseDealList {
  area: number;
  dealDay: string;
  dealMonth: string;
  dealType: DealType;
  dealYear: string;
  floor: string;
  houseDealId: number;
  houseInfoId: number;
  price: number;
  rent: number;
}
export interface HouseInfoDto {
  buildYear: string;
  dongCode: string;
  houseInfoId: number;
  houseName: string;
  houseType: HouseType;
  jibun: string;
  jibunAddress: string;
}
export interface DongDto {
  dongCode: string;
  dongName: string;
  gugunCode: string;
  sidoCode: string;
}

export interface HouseOnSaleList {
  bathCount: string;
  contractArea: number;
  createBy: number;
  createdTime: Date;
  dealType: DealType;
  dirType: DirType;
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
  updateBy: number;
  updatedTime: Date;
}

// OneRoom & TwoRoom CommonTypes
export interface VillaMapRoomRs extends CommonReponseType {
  data: VillaMapDataType;
}

export interface VillaListRoomDataType {
  houseOnSaleVillaJEONSEList: HouseOnSaleVillaDto;
  houseOnSaleVillaMAEMAEList: HouseOnSaleVillaDto;
  houseOnSaleVillaWOLSELList: HouseOnSaleVillaDto;
  houseType: HouseType;
  jibunAddress: string;
}

export interface VillaListRoomType {
  data: VillaListRoomDataType;
}

export interface HouseOnSaleVillaDto {
  bathCount: string;
  contractArea: number;
  createdTime: Date;
  dealType: DealType;
  dirType: DirType;
  dongCode: string;
  floor: string;
  houseOnSaleVillaId: number;
  houseType: string;
  jibunAddress: string;
  mngFee: number;
  movingDate: string;
  netLeasableArea: number;
  parkCount: string;
  price: number;
  rent: number;
  roomCount: string;
  totalFloor: string;
  updatedTime: Date;
}

export interface JibunAddressToCountingMapType {
  description: number;
}

export interface VillaMapDataType {
  dongCode: string;
  houseType: HouseType;
  jibunAddressToCountingMap: JibunAddressToCountingMapType;
}
