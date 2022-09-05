import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import DongListVO from 'src/domain/vo/adress/DongListVO';
import GugunListVO from 'src/domain/vo/adress/GugunListVO';
import SidoListVO from 'src/domain/vo/adress/SidoListVO';

const address_key = 'address';

export const fetchAddressDong = async (dong: string) => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressDong(dong);
  return new DongListVO(data);
};

export const fetchAddressGugun = async (gugun: string) => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressGugun(gugun);
  return new GugunListVO(data);
}

export const fetchAddressSido = async () => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressSido();
  return new SidoListVO(data);
}

export function useAddressDong(dong: string) {
  return useQuery([address_key, 'dong' ,dong], () => fetchAddressDong(dong));
}

export function useAddressGugun(gugun: string){
  return useQuery([address_key,'gugun',gugun], () => fetchAddressGugun(gugun));
}

export function useAddressSido(){
  return useQuery([address_key, 'sido'], () => fetchAddressSido());
}
