import { DealType, DirType, HouseOnSaleList } from 'src/domain/rs/commonTypes';

import { HouseListRs } from 'src/domain/rs/house/list';
import { MapVO } from '../commonVo';

/**
 * @description fetchHouseList에서 데이터를 핸들링 한 후 리턴해주는 VO
 */
export default class HouseListVO {
  houseOnSaleJEONSEList: HouseOnSaleVO[];
  houseOnSaleMAEMAEList: HouseOnSaleVO[];
  houseOnSaleWOLSEList: HouseOnSaleVO[];
  houseInfoDto: MapVO;
  constructor(rs: HouseListRs) {
    this.houseOnSaleJEONSEList = rs.data.houseOnSaleJEONSEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
    this.houseOnSaleMAEMAEList = rs.data.houseOnSaleMAEMAEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
    this.houseOnSaleWOLSEList = rs.data.houseOnSaleWOLSEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
    this.houseInfoDto = new MapVO(rs.data.houseInfoDto);
  }
}

export class HouseOnSaleVO {
  bathCount: number;
  contractArea: number;
  createBy: number;
  createdTime: Date;
  dealType: DealType;
  dirType: DirType;
  floor: number;
  houseInfoId: number;
  houseOnSaleId: number;
  mngFee: number;
  movingDate: string;
  netLeasableArea: number;
  parkCount: number;
  price: number;
  rent: number;
  roomCount: number;
  totalFloor: number;
  updateBy: number;
  updatedTime: Date;

  constructor(dto: HouseOnSaleList) {
    this.bathCount = Number(dto.bathCount);
    this.contractArea = dto.contractArea;
    this.createBy = dto.createBy;
    this.createdTime = dto.createdTime;
    this.dealType = dto.dealType;
    this.dirType = dto.dirType;
    this.floor = Number(dto.floor);
    this.houseInfoId = dto.houseInfoId;
    this.houseOnSaleId = dto.houseOnSaleId;
    this.mngFee = dto.mngFee;
    this.movingDate = dto.movingDate;
    this.netLeasableArea = dto.netLeasableArea;
    this.parkCount = Number(dto.parkCount);
    this.price = dto.price;
    this.rent = dto.rent;
    this.roomCount = Number(dto.roomCount);
    this.totalFloor = Number(dto.totalFloor);
    this.updateBy = dto.updateBy;
    this.updatedTime = dto.updatedTime;
  }
}
