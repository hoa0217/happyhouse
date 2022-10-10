import customAxios from 'src/utils/axios';
import { AxiosResponse } from 'axios';
import { VillaDetailRs } from 'src/domain/rs/villa/detail';
import { VillaListOneroomRs } from 'src/domain/rs/villa/list/oneroom';
import { VillaListTworoomRs } from 'src/domain/rs/villa/list/tworoom';
import { VillaMapOneroomRs } from 'src/domain/rs/villa/map/oneroom';
import { VillaMapTworoomRs } from 'src/domain/rs/villa/map/tworoom';

export default interface VillaStore {
  /**
   * @param houseOnSaleVillaId number
   * @description 클릭한 원룸/투룸 상세 정보를 반환하는 Promise 함수
   */
  fetchVillaDetail(houseOnSaleVillaId: number): Promise<AxiosResponse<VillaDetailRs>>;
  /**
   * @param jibunAddress string
   * @description 특정 원룸에 대한 매물 정보 리스트를 반환하는 Promise 함수
   */
  fetchVillaListOneroom(jibunAddress: string): Promise<AxiosResponse<VillaListOneroomRs>>;
  /**
   * @param jibunAddress
   * @description 특정 투룸에 대한 매물 정보 리스트를 반환하는 Promise 함수
   */
  fetchVillaListTworoom(jibunAddress: string): Promise<AxiosResponse<VillaListTworoomRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 원룸 정보 리스트를 반환하는 Promise 함수
   */
  fetchVillaMapOneroom(dongCode: string): Promise<AxiosResponse<VillaMapOneroomRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 투룸 정보 리스트를 반환하는 Promise 함수
   */
  fetchVillaMapTworoom(dongCode: string): Promise<AxiosResponse<VillaMapTworoomRs>>;
}

export class RemoteVillaRepo implements VillaStore {
  fetchVillaDetail(houseOnSaleVillaId: number) {
    return customAxios.get<VillaDetailRs>(`/villa/detail/${houseOnSaleVillaId}`);
  }
  fetchVillaListOneroom(jibunAddress: string) {
    return customAxios.get<VillaListOneroomRs>(`villa/list/oneroom/${jibunAddress}`);
  }
  fetchVillaListTworoom(jibunAddress: string) {
    return customAxios.get<VillaListTworoomRs>(`villa/list/tworoom/${jibunAddress}`);
  }
  fetchVillaMapOneroom(dongCode: string) {
    return customAxios.get<VillaMapOneroomRs>(`villa/map/oneroom/${dongCode}`);
  }
  fetchVillaMapTworoom(dongCode: string) {
    return customAxios.get<VillaMapTworoomRs>(`villa/map/oneroom/${dongCode}`);
  }
}
