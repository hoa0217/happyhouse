// 공통적으로 쓰이는 타입 모아 놓은 곳
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

// APT & OFFICETEL Common Types
export interface DealDataType {
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
export interface InfoDtoType {
  buildYear: string;
  dongCode: string;
  houseInfoId: number;
  houseName: string;
  houseType: HouseType;
  jibun: string;
  jibunAddress: string;
}
export interface DongDtoType {
  dongCode: string;
  dongName: string;
  gugunCode: string;
  sidoCode: string;
}

// OneRoom & TwoRoom Common Types
export interface HouseOnSaleVillaDtoType {
  bathCount: string;
  contractArea: number;
  createdTime: Date;
  dealType: DealType;
  dirType: DirType;
  dongCode: string;
  floor: string;
  houseOnSaleVillaId: number;
  houseType: HouseType;
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
