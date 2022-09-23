import OfficeHouseListRs, { houseOnSale } from 'src/domain/rs/house/officetel/OfficeHouseListRs';

export default class OfficeHouseListVO {
  houseOnSaleJEONSEList: OfficeHouseVO[];
  houseOnSaleMAEMAEList: OfficeHouseVO[];
  houseOnSaleWOLSEList: OfficeHouseVO[];

  constructor(rs: OfficeHouseListRs) {
    this.houseOnSaleJEONSEList = rs.data.houseOnSaleJEONSEList.map((house) => new OfficeHouseVO(house));
    this.houseOnSaleMAEMAEList = rs.data.houseOnSaleMAEMAEList.map((house) => new OfficeHouseVO(house));
    this.houseOnSaleWOLSEList = rs.data.houseOnSaleWOLSEList.map((house) => new OfficeHouseVO(house));
  }
}

export class OfficeHouseVO {
  bathCount: number;
  contractArea: number;
  createdTime: string;
  dealType: 'JEONSE' | 'MAEMAE' | 'WOLSE';
  dirType: 'EAST' | 'NORTH' | 'NORTHEAST' | 'NORTHWEST' | 'SOUTH' | 'SOUTHEAST' | 'SOUTHWEST' | 'WEST';
  dongCode: number;
  floor: number;
  houseInfoId: number;
  houseOnSaleId: number;
  mngFee: number;
  movingDate: string;
  netLeasableArea: number;
  parkCount: number;
  price: number;
  rent: number;
  roomCount: string;
  totalFloor: string;
  updatedTime: string;

  constructor(dto: houseOnSale) {
    this.bathCount = Number(dto.bathCount);
    this.contractArea = dto.contractArea;
    this.createdTime = dto.createdTime;
    this.dealType = dto.dealType;
    this.dirType = dto.dirType;
    this.dongCode = Number(dto.dongCode);
    this.floor = Number(dto.floor);
    this.houseInfoId = dto.houseInfoId;
    this.houseOnSaleId = dto.houseOnSaleId;
    this.mngFee = dto.mngFee;
    this.movingDate = dto.movingDate;
    this.netLeasableArea = dto.netLeasableArea;
    this.parkCount = Number(dto.parkCount);
    this.price = dto.price;
    this.rent = dto.rent;
    this.roomCount = dto.roomCount;
    this.totalFloor = dto.totalFloor;
    this.updatedTime = dto.updatedTime;
  }
}
