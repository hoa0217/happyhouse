import axios, { AxiosResponse } from 'axios';
import DongListRs from 'src/domain/rs/adress/DongListRs';
import GugunListRs from 'src/domain/rs/adress/GugunListRs';
import customAxios from 'src/utils/axios';

export default interface AddressStore {
  fetchAddressDong(dong: string): Promise<AxiosResponse<DongListRs>>;
  fetchAddressGugun(gugun: string): Promise<AxiosResponse<GugunListRs>>;
}

export class RemoteAddressRepo implements AddressStore {
  fetchAddressDong(dong: string) {
    return customAxios.get<DongListRs>(`/address/dong/${dong}`);
  }
  fetchAddressGugun(gugun: string) {
    return axios.get<GugunListRs>(`https://happy-haapyhouse.herokuapp.com/address/gugun/${gugun}`);
  }
}

