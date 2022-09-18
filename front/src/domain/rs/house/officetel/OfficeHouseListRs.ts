export default interface OfficeHouseListRs {
  data: DataList;
}

export interface DataList {
  houseOnSaleJEONSEList: houseOnSale[];
  houseOnSaleMAEMAEList: houseOnSale[];
  houseOnSaleWOLSEList: houseOnSale[];
}

export interface houseOnSale {
  bathCount: string;
  contractArea: number;
  createdTime: string;
  dealType: 'JEONSE' | 'MAEMAE' | 'WOLSE';
  dirType: 'EAST' | 'NORTH' | 'NORTHEAST' | 'NORTHWEST' | 'SOUTH' | 'SOUTHEAST' | 'SOUTHWEST' | 'WEST';
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
  updatedTime: string;
}
