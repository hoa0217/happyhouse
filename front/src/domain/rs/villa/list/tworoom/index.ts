import { HouseOnSaleVillaDtoType, ResponseCodeType, HouseType } from 'src/domain/rs/types';

export interface VillaListTworoomDataType {
  houseOnSaleVillaJEONSEList: HouseOnSaleVillaDtoType;
  houseOnSaleVillaMAEMAEList: HouseOnSaleVillaDtoType;
  houseOnSaleVillaWOLSELList: HouseOnSaleVillaDtoType;
  houseType: HouseType;
  jibunAddress: string;
}

export interface VillaListTworoomRs {
  data: VillaListTworoomDataType;
  message: string;
  responseCode: ResponseCodeType;
}
