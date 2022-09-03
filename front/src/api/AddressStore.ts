import axios, { AxiosResponse } from 'axios';
import DongListRs from 'src/domain/rs/adress/DongListRs';
import customAxios from 'src/utils/axios';

export default interface AddressStore {
  fetchAddressDong(dong: string): Promise<AxiosResponse<DongListRs>>;
}

export class RemoteAddressRepo implements AddressStore {
  fetchAddressDong(dong: string) {
    return customAxios.get<DongListRs>(`/address/dong/${dong}`);
  }
}
