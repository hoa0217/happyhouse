import { AxiosResponse } from 'axios';
import customAxios from 'src/utils/axios';
import MapListRs from 'src/domain/rs/house/apt/MapListRs';
import HouseInfoListRs from 'src/domain/rs/house/apt/HouseInfoListRs';
import OfficeMapListRs from 'src/domain/rs/house/officetel/OfficeMapListRs';
import OfficeHouseListRs from 'src/domain/rs/house/officetel/OfficeHouseListRs';

import { HouseDetailRs } from 'src/domain/rs/house/detail';
import { HouseListRs } from 'src/domain/rs/house/list';
import { HouseMapAptRs } from 'src/domain/rs/house/map/apt';
import { HouseMapOfficetelRs } from 'src/domain/rs/house/map/officetel';

export default interface HouseStore {
  fetchHouseAptMap(dongCode: string): Promise<AxiosResponse<MapListRs>>;
  fetchHouseAptList(houseInfoId: string): Promise<AxiosResponse<HouseInfoListRs>>;
  fetchHouseOfficetelMap(dongCode: string): Promise<AxiosResponse<OfficeMapListRs>>;
  fetchHouseOfficetelList(houseInfoId: string): Promise<AxiosResponse<OfficeHouseListRs>>;

  /**
   * @param houseOnSaleId number
   * @description 클릭한 아파트/오피스텔 매물 상세 정보를 반환하는 Promise 함수
   */
  fetchHouseDetail(houseOnSaleId: number): Promise<AxiosResponse<HouseDetailRs>>;
  /**
   * @param houseInfoId number
   * @description 클릭한 아파트/오피스텔 매물 상세 정보를 반환하는 Promise 함수
   */
  fetchHouseList(houseInfoId: number): Promise<AxiosResponse<HouseListRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 아파트 정보 리스트를 반환하는 Promise 함수
   */
  fetchHouseMapApt(dongCode: string): Promise<AxiosResponse<HouseMapAptRs>>;
  /**
   * @param dongCode string
   * @description 동에 있는 오피스텔정보 리스트를 반환하는 Promise 함수
   */
  fetchHouseMapOfficetel(dongCode: string): Promise<AxiosResponse<HouseMapOfficetelRs>>;
}

export class RemoteHouseRepo implements HouseStore {
  fetchHouseAptMap(dongCode: string) {
    return customAxios.get<MapListRs>(`/house/map/apt/${dongCode}`);
  } // fetchHouseMapApt로 대체해야함
  fetchHouseAptList(houseInfoId: string) {
    return customAxios.get<HouseInfoListRs>(`/house/list/${houseInfoId}`);
  } //fetchHouseList로 대체해야함
  fetchHouseOfficetelMap(dongCode: string) {
    return customAxios.get<OfficeMapListRs>(`house/map/officetel/${dongCode}`);
  } // fetchHouseMapOfficetel로 대체해야함
  fetchHouseOfficetelList(houseInfoId: string) {
    return customAxios.get<OfficeHouseListRs>(`house/list/${houseInfoId}`);
  } // fetchHouseList로 대체해야함

  // APT & OFFICETEL Controller
  fetchHouseDetail(houseOnSaleId: number) {
    return customAxios.get<HouseDetailRs>(`house/detail/${houseOnSaleId}`);
  }
  fetchHouseList(houseInfoId: number) {
    return customAxios.get<HouseListRs>(`house/list/${houseInfoId}`);
  }
  fetchHouseMapApt(dongCode: string) {
    return customAxios.get<HouseMapAptRs>(`house/map/apt/${dongCode}`);
  }
  fetchHouseMapOfficetel(dongCode: string) {
    return customAxios.get<HouseMapOfficetelRs>(`house/map/officetel/${dongCode}`);
  }
}
