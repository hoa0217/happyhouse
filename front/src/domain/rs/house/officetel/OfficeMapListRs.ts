export default interface OfficeMapListRs {
  data: houseInfoDtoList[];
}

export interface houseInfoDtoList {
  buildYear: string;
  dongCode: string;
  houseInfoId: number;
  houseName: string;
  houseType: 'APT' | 'OFFICETEL' | 'ONEROOM' | 'TWOROOM';
  jiBun: string;
  jibunAddress: string;
}
