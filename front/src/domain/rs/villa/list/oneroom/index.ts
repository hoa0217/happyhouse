import { ResponseCodeType, HouseOnSaleVillaDtoType, HouseType } from 'src/domain/rs/types';

export interface VillaListOneroomDataType {
  houseOnSaleVillaJEONSEList: HouseOnSaleVillaDtoType;
  houseOnSaleVillaMAEMAEList: HouseOnSaleVillaDtoType;
  houseOnSaleVillaWOLSELList: HouseOnSaleVillaDtoType;
  houseType: HouseType;
  jibunAddress: string;
}

export interface VillaListOneroomRs {
  data: VillaListOneroomDataType;
  message: string;
  responseCode: ResponseCodeType;
}
