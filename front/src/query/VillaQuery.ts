import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';

export const VillaQueryKeys = {
  VILLADETAIL: (houseOnSaleVillaId: number) => ['villa', 'detail', houseOnSaleVillaId] as const,
  VILLALISTONEROOM: (jibunAddress: string) => ['villa', 'list', 'oneroom', jibunAddress] as const,
  VILLALISTTWOROOM: (jibunAddress: string) => ['villa', 'list', 'tworoom', jibunAddress] as const,
  VILLAMAPONEROOM: (dongCode: string) => ['viila', 'map', 'oneroom', dongCode] as const,
  VILLAMAPTWOROOM: (dongCode: string) => ['viila', 'map', 'tworoom', dongCode] as const,
};

/**
 * @param houseOnSaleVillaId number
 * @description 클릭한 원룸/투룸 상세 정보를 가져오는 쿼리
 */
export function useVillaDetail(houseOnSaleVillaId: number) {
  return useQuery(VillaQueryKeys.VILLADETAIL(houseOnSaleVillaId), () => fetchVillaDetail(houseOnSaleVillaId));
}
export async function fetchVillaDetail(houseOnSaleVillaId: number) {
  const { data } = await apiStore.remoteVillaRepo.fetchVillaDetail(houseOnSaleVillaId);
  return data;
}

/**
 * @param jibunAddress string
 * @description 특정 원룸에 대한 매물 정보 리스트를 가져오는 쿼리
 */
export function useVillaListOneroom(jibunAddress: string) {
  return useQuery(VillaQueryKeys.VILLALISTONEROOM(jibunAddress), () => fetchVillaListOneroom(jibunAddress));
}
export async function fetchVillaListOneroom(jibunAddress: string) {
  const { data } = await apiStore.remoteVillaRepo.fetchVillaListOneroom(jibunAddress);
  return data;
}

/**
 * @param jibunAddress string
 * @description 특정 투룸에 대한 매물 정보 리스트를 가져오는 쿼리
 */
export function useVillaListTworoom(jibunAddress: string) {
  return useQuery(VillaQueryKeys.VILLALISTTWOROOM(jibunAddress)), () => fetchVillaListTworoom(jibunAddress);
}
export async function fetchVillaListTworoom(jibunAddress: string) {
  const { data } = await apiStore.remoteVillaRepo.fetchVillaListTworoom(jibunAddress);
  return data;
}

/**
 * @param dongCode string
 * @description 동에 있는 원룸 정보 리스트를 가져오는 쿼리
 */
export function useVillaMapOneroom(dongCode: string) {
  return useQuery(VillaQueryKeys.VILLAMAPONEROOM(dongCode), () => fetchVillaMapOneroom(dongCode));
}
export async function fetchVillaMapOneroom(dongCode: string) {
  const { data } = await apiStore.remoteVillaRepo.fetchVillaMapOneroom(dongCode);
  return data;
}

/**
 * @param dongCode string
 * @description 동에 있는 투룸 정보 리스트를 가져오는 쿼리
 */
export function useViilaMapTworoom(dongCode: string) {
  return useQuery(VillaQueryKeys.VILLAMAPTWOROOM(dongCode), () => fetchViilaMapTworoom(dongCode));
}
export async function fetchViilaMapTworoom(dongCode: string) {
  const { data } = await apiStore.remoteVillaRepo.fetchVillaMapTworoom(dongCode);
  return data;
}
