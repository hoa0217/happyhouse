import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import MapListVO from 'src/domain/vo/house/apt/MapListVO';

const keys = ['house', 'apt'];

export const fetchHouseAptMap = async (dongCode: string) => {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseAptMap(dongCode);
  return new MapListVO(data);
};
//어떻게 작성??
export const fetchHouseAptList = async (houseInfoId: string) => {};

export function useHouseAptMap(dongCode: string) {
  return useQuery([...keys, 'map', dongCode], () => fetchHouseAptMap(dongCode));
}

export function useHouseDetail(houseOnSaleId: string) {
  const {
    remoteHouseRepo: { fetchHouseDetail },
  } = apiStore;
  return useQuery(['houseDetail', houseOnSaleId], () => fetchHouseDetail(houseOnSaleId), {
    onSuccess: (data) => {
      console.log('fetch success!', data);
    },
    onError: (error) => {
      console.log('fetch fail!', error);
    },
  });
}