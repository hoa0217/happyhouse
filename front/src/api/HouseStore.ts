import { AxiosResponse } from 'axios';
import customAxios from 'src/utils/axios';

import { HouseDetailRs } from 'src/domain/rs/house/detail';
import { HouseListRs } from 'src/domain/rs/house/list';
import { HouseMapAptRs } from 'src/domain/rs/house/map/apt';
import { HouseMapOfficetelRs } from 'src/domain/rs/house/map/officetel';
export default interface HouseStore {
  /**
   * @param houseOnSaleId number
   * @description 클릭한 아파트/오피스텔 매물 상세 정보를 반환하는 Promise 함수
   */
  fetchHouseDetail(houseOnSaleId: number): Promise<AxiosResponse<HouseDetailRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 아파트 정보 리스트를 반환하는 Promise 함수
   */
  fetchHouseMapApt(dongCode: string): Promise<AxiosResponse<HouseMapAptRs>>;
  /**
   * @param houseInfoId number
   * @description 클릭한 아파트/오피스텔 매물 상세 정보를 반환하는 Promise 함수
   */
  fetchHouseList(houseInfoId: number): Promise<AxiosResponse<HouseListRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 오피스텔정보 리스트를 반환하는 Promise 함수
   */
  fetchHouseMapOfficetel(dongCode: string): Promise<AxiosResponse<HouseMapOfficetelRs>>;
}

export class RemoteHouseRepo implements HouseStore {
  fetchHouseDetail(houseOnSaleId: number) {
    return customAxios.get<HouseDetailRs>(`house/detail/${houseOnSaleId}`);
  }
  fetchHouseMapApt(dongCode: string) {
    return customAxios.get<HouseMapAptRs>(`/house/map/apt/${dongCode}`);
  }
  fetchHouseList(houseInfoId: number) {
    return customAxios.get<HouseListRs>(`/house/list/${houseInfoId}`);
  }
  fetchHouseMapOfficetel(dongCode: string) {
    return customAxios.get<HouseMapOfficetelRs>(`house/map/officetel/${dongCode}`);
  }
}
