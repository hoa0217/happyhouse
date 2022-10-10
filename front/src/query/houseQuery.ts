import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import HouseInfoListVO from 'src/domain/vo/house/apt/HouseInfoListVO';
import MapListVO from 'src/domain/vo/house/apt/MapListVO';
import OfficeHouseListVO from 'src/domain/vo/house/officetel/OfficeHouseInfoListVO';
import OfficeMapListVO from 'src/domain/vo/house/officetel/OfficeMapListVO';

const keys = ['house', 'apt'];

export const HouseQueryKeys = {
  HOUSEDETAIL: (houseOnSaleId: number) => ['house', 'detail', houseOnSaleId] as const,
  HOUSELIST: (houseInfoId: number) => ['house', 'list', houseInfoId] as const,
  HOUSEMAPAPT: (dongCode: string) => ['house', 'map', 'apt', dongCode] as const,
  HOUSEMAPOFFICETEL: (dongCode: string) => ['house', 'map', 'officetel', dongCode] as const,
};

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

/**
 * @param houseOnSaleId number
 * @description 클릭한 아파트/오피스텔 매물 상세 정보를 가져오는 쿼리
 */
export function useHouseDetail(houseOnSaleId: number) {
  return useQuery(
    HouseQueryKeys.HOUSEDETAIL(houseOnSaleId),
    () => apiStore.remoteHouseRepo.fetchHouseDetail(houseOnSaleId),
    {
      enabled: !!houseOnSaleId, // houseOnSaleId 값이 있을때만 실횅
    },
  );
}
/**
 * @param houseInfoId number
 * @description 클릭한 아파트/오피스텔 매물 상세 정보를 가져오는 쿼리
 */
export function useHouseList(houseInfoId: number) {
  return useQuery(HouseQueryKeys.HOUSELIST(houseInfoId), () => apiStore.remoteHouseRepo.fetchHouseList(houseInfoId));
}
/**
 * @param dongCode string
 * @description 동에 있는 아파트 정보 리스트를 가져오는 쿼리
 */
export function useHouseMapApt(dongCode: string) {
  return useQuery(HouseQueryKeys.HOUSEMAPAPT(dongCode), () => apiStore.remoteHouseRepo.fetchHouseMapApt(dongCode));
}
/**
 * @param dongCode string
 * @description 동에 있는 오피스텔정보 리스트를 가져오는 쿼리
 */
export function useHouseMapOffietel(dongCode: string) {
  return useQuery(HouseQueryKeys.HOUSEMAPOFFICETEL(dongCode), () =>
    apiStore.remoteHouseRepo.fetchHouseMapOfficetel(dongCode),
  );
}
