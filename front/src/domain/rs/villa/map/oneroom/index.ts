import { ResponseCodeType, VillaMapDataType } from 'src/domain/rs/types';

export interface VillaMapOneroomRs {
  data: VillaMapDataType;
  message: string;
  responseCode: ResponseCodeType;
}
