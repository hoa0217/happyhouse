export default interface DongListRs {
  data: DongDto[];
}

export interface DongDto {
  dongCode: string;
  dongName: string;
  gugunCode: string;
  sidoCode: string;
}
