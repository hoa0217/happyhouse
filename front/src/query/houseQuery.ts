import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import { IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';
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

export function useHouseDetail(houseOnSaleId: IdRs) {
  return useQuery(['houseDetail', houseOnSaleId], () => apiStore.remoteHouseRepo.fetchHouseDetail(houseOnSaleId), {
    // houseOnSaleId 값이 있을때만 실횅
    enabled: !!houseOnSaleId,
  });
}
