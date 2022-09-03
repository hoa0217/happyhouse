import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import DongListVO from 'src/domain/vo/adress/DongListVO';
import GugunListVO from 'src/domain/vo/adress/GugunListVO';

const keys = 'address';

export const fetchAddressDong = async (dong: string) => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressDong(dong);
  return new DongListVO(data);
};

export const fetchAddressGugun = async (gugun: string) => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressGugun(gugun);
  return new GugunListVO(data);
}

export function useAddressDong(dong: string) {
  return useQuery([keys, 'dong' ,dong], () => fetchAddressDong(dong));
}

export function useAddressGugun(gugun: string){
  return useQuery([keys,'gugun',gugun], () => fetchAddressGugun(gugun));
}
