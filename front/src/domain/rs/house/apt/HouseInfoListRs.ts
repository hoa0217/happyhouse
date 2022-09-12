export default interface HouseInfoListRs {
    data : DataList
}

interface DataList {
    houseOnSaleJEONSEList : HouseOnSale[];
    houseOnSaleMAEMAEList : HouseOnSale[];
    houseOnSaleWOLSEList : HouseOnSale[];
}


export interface HouseOnSale {
    bathCount : string;
    contractArea : number;
    createdBy : string;
    createdTime : string;
    dealType : string;
    dirType : string;
    dongCode : string;
    floor : string;
    houseInfoId : number;
    houseOnSaleId : number;
    mngFee : number;
    movingDate: string;
    netLeasableArea : number;
    parkCount : string;
    price : number;
    rent : number;
    roomCount : String;
    totalFloor : string;
    updateBy : string;
    updatedTime : string;
}





