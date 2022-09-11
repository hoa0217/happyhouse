import HouseInfoListRs, { HouseOnSale } from "src/domain/rs/house/apt/houseInfoListRs";

export default class HouseInfoListVO {
    houseOnSaleJEONSEList : HouseOnSaleVO[];
    houseOnSaleMAEMAEList : HouseOnSaleVO[];
    houseOnSaleWOLSEList : HouseOnSaleVO[];

    constructor(rs:HouseInfoListRs){
        this.houseOnSaleJEONSEList = rs.houseOnSaleJEONSEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
        this.houseOnSaleMAEMAEList = rs.houseOnSaleMAEMAEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
        this.houseOnSaleWOLSEList = rs.houseOnSaleWOLSEList.map((HouseOnSale) => new HouseOnSaleVO(HouseOnSale));
    }
}

export class HouseOnSaleVO {
    bathCount : number;
    contractArea : number;
    createdBy : string;
    createdTime : string;
    dealType : string;
    dirType : string;
    dongCode : number;
    floor : number;
    houseInfoId : number;
    houseOnSaleId : number;
    mngFee : number;
    movingDate : string;
    netLeasableArea : number;
    parkCount : number;
    price : number;
    rent : number;
    roomCount : number;
    totalFloor : number;
    updateBy : string;
    updatedTime : string;

    constructor(dto:HouseOnSale){
        this.bathCount = Number(dto.bathCount);
        this.contractArea = dto.contractArea;
        this.createdBy = dto.createdBy;
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
        this.roomCount = Number(dto.roomCount);
        this.totalFloor = Number(dto.totalFloor);
        this.updateBy = dto.updateBy;
        this.updatedTime = dto.updatedTime;

    }
}