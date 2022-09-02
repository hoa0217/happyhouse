import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import DongListVO from 'src/domain/vo/adress/DongListVO';

const keys = ['address', 'dong'];

export const fetchAddressDong = async (dong: string) => {
  const { data } = await apiStore.remoteAddressRepo.fetchAddressDong(dong);
  return new DongListVO(data);
};

export default function useAddressDong(dong: string) {
  return useQuery([...keys, dong], () => fetchAddressDong(dong));
}
