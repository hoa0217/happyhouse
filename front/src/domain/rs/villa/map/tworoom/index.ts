import { ResponseCodeType, VillaMapDataType } from 'src/domain/rs/types';

export interface VillaMapTworoomRs {
  data: VillaMapDataType;
  message: string;
  responseCode: ResponseCodeType;
}
