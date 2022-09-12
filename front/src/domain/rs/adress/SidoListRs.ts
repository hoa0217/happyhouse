export default interface SidoListRs {
  data: SidoDto[];
}

export interface SidoDto {
  sidoCode: string;
  sidoName: string;
}
