import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import { IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';
import HouseInfoListVO from 'src/domain/vo/house/apt/HouseInfoListVO';
import MapListVO from 'src/domain/vo/house/apt/MapListVO';
import OfficeHouseListVO from 'src/domain/vo/house/officetel/OfficeHouseInfoListVO';
import OfficeMapListVO from 'src/domain/vo/house/officetel/OfficeMapListVO';

const keys = ['house', 'apt'];

export const fetchHouseAptMap = async (dongCode: string) => {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseAptMap(dongCode);
  return new MapListVO(data);
};

export const fetchHouseAptList = async (houseInfoId: string) => {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseAptList(houseInfoId);
  return new HouseInfoListVO(data);
};

export function useHouseAptMap(dongCode: string) {
  return useQuery([...keys, 'map', dongCode], () => fetchHouseAptMap(dongCode));
}

export function useHouseAptList(houseInfoId: string) {
  return useQuery([...keys, 'list', houseInfoId], () => fetchHouseAptList(houseInfoId));
}

export function useHouseDetail(houseOnSaleId: IdRs) {
  return useQuery(['houseDetail', houseOnSaleId], () => apiStore.remoteHouseRepo.fetchHouseDetail(houseOnSaleId), {
    // houseOnSaleId 값이 있을때만 실횅
    enabled: !!houseOnSaleId,
  });
}

export const fetchHouseOfficetelMap = async (dongCode: string) => {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseOfficetelMap(dongCode);
  return new OfficeMapListVO(data);
};

export function useHouseOfficeMap(dongCode: string) {
  return useQuery(['house', 'officetel', 'map', dongCode], () => fetchHouseOfficetelMap(dongCode));
}

export const fetchHouseOfficetelList = async (houseInfoId: string) => {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseOfficetelList(houseInfoId);
  return new OfficeHouseListVO(data);
};

export function useHouseOfficeList(houseInfoId: string) {
  return useQuery(['house', 'officetel', 'list', houseInfoId], () => fetchHouseOfficetelList(houseInfoId));
}
