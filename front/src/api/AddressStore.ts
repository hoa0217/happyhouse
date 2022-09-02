import axios, { AxiosResponse } from 'axios';
import DongListRs from 'src/domain/rs/adress/DongListRs';

export default interface AddressStore {
  fetchAddressDong(dong: string): Promise<AxiosResponse<DongListRs>>;
}

export class RemoteAddressRepo implements AddressStore {
  fetchAddressDong(dong: string) {
    return axios.get<DongListRs>(`https://happy-haapyhouse.herokuapp.com/address/dong/${dong}`);
  }
}
