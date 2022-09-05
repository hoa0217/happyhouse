import axios, { AxiosResponse } from 'axios';
import DongListRs from 'src/domain/rs/adress/DongListRs';
import GugunListRs from 'src/domain/rs/adress/GugunListRs';
import SidoListRs from 'src/domain/rs/adress/SidoListRs';
import customAxios from 'src/utils/axios';

export default interface AddressStore {
  fetchAddressDong(dong: string): Promise<AxiosResponse<DongListRs>>;
  fetchAddressGugun(gugun: string): Promise<AxiosResponse<GugunListRs>>;
  fetchAddressSido():Promise<AxiosResponse<SidoListRs>>
}

export class RemoteAddressRepo implements AddressStore {
  fetchAddressDong(dong: string) {
    return customAxios.get<DongListRs>(`/address/dong/${dong}`);
  }
  fetchAddressGugun(gugun: string) {
    return customAxios.get<GugunListRs>(`/address/gugun/${gugun}`);
  }
  fetchAddressSido(){
    return customAxios.get<SidoListRs>(`/address/sido`);
  }
}

