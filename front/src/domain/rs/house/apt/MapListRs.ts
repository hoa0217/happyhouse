export default interface MapListRs {
  data: houseInfoDtoList;
}

export interface houseInfoDtoList {
  houseInfoDtoList: houseInfoDto[];
}

export interface houseInfoDto {
  buildYear: string;
  dongCode: string;
  houseInfoId: number;
  houseName: string;
  houseType: string;
  jibun: string;
  jibunAddress: string;
}
