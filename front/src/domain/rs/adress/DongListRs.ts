export default interface DongListRs {
  dongDtoList: DongDto[];
}

export interface DongDto {
  dongCode: string;
  dongName: string;
  gugunCode: string;
  sidoCode: string;
}
