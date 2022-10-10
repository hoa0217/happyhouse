import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import HouseListVO from 'src/domain/vo/house/list';
import HouseMapAptListVO from 'src/domain/vo/house/map/apt';
import HouseMapOfficetelListVO from 'src/domain/vo/house/map/officetel';

export const HouseQueryKeys = {
  HOUSEDETAIL: (houseOnSaleId: number) => ['house', 'detail', houseOnSaleId] as const,
  HOUSELIST: (houseInfoId: number) => ['house', 'list', houseInfoId] as const,
  HOUSEMAPAPT: (dongCode: string) => ['house', 'map', 'apt', dongCode] as const,
  HOUSEMAPOFFICETEL: (dongCode: string) => ['house', 'map', 'officetel', dongCode] as const,
};

/**
 * @param houseOnSaleId number
 * @description 클릭한 아파트/오피스텔 매물 상세 정보를 가져오는 쿼리
 */
export function useHouseDetail(houseOnSaleId: number) {
  return useQuery(HouseQueryKeys.HOUSEDETAIL(houseOnSaleId), () => fetchHouseDetail(houseOnSaleId), {
    enabled: !!houseOnSaleId, // houseOnSaleId 값이 있을때만 실횅
  });
}
export async function fetchHouseDetail(houseOnSaleId: number) {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseDetail(houseOnSaleId);
  return data;
}

/**
 * @param houseInfoId number
 * @description 클릭한 아파트/오피스텔 매물 상세 정보를 가져오는 쿼리
 */
export function useHouseList(houseInfoId: number) {
  return useQuery(HouseQueryKeys.HOUSELIST(houseInfoId), () => fetchHouseList(houseInfoId));
}
export async function fetchHouseList(houseInfoId: number) {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseList(houseInfoId);
  return new HouseListVO(data);
}

/**
 * @param dongCode string
 * @description 동에 있는 아파트 정보 리스트를 가져오는 쿼리
 */
export function useHouseMapApt(dongCode: string) {
  return useQuery(HouseQueryKeys.HOUSEMAPAPT(dongCode), () => fetchHouseMapApt(dongCode));
}
export async function fetchHouseMapApt(dongCode: string) {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseMapApt(dongCode);
  return new HouseMapAptListVO(data);
}

/**
 * @param dongCode string
 * @description 동에 있는 오피스텔 정보 리스트를 가져오는 쿼리
 */
export function useHouseMapOfficetel(dongCode: string) {
  return useQuery(['house', 'officetel', 'map', dongCode], () => fetchHouseMapOfficetel(dongCode));
}
export async function fetchHouseMapOfficetel(dongCode: string) {
  const { data } = await apiStore.remoteHouseRepo.fetchHouseMapOfficetel(dongCode);
  return new HouseMapOfficetelListVO(data);
}
