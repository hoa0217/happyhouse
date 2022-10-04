import { AxiosResponse } from 'axios';
import customAxios from 'src/utils/axios';
import MapListRs from 'src/domain/rs/house/apt/MapListRs';
import HouseInfoListRs from 'src/domain/rs/house/apt/HouseInfoListRs';
import { HouseDetailDataRs, HouseDetailRs, IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';
import OfficeMapListRs from 'src/domain/rs/house/officetel/OfficeMapListRs';
import OfficeHouseListRs from 'src/domain/rs/house/officetel/OfficeHouseListRs';

export default interface HouseStore {
  fetchHouseAptMap(dongCode: string): Promise<AxiosResponse<MapListRs>>;
  fetchHouseAptList(houseInfoId: string): Promise<AxiosResponse<HouseInfoListRs>>;
  fetchHouseDetail(houseOnSaleId: IdRs): Promise<HouseDetailDataRs>;
  fetchHouseOfficetelMap(dongCode: string): Promise<AxiosResponse<OfficeMapListRs>>;
  fetchHouseOfficetelList(houseInfoId: string): Promise<AxiosResponse<OfficeHouseListRs>>;
}

export class RemoteHouseRepo implements HouseStore {
  fetchHouseAptMap(dongCode: string) {
    return customAxios.get<MapListRs>(`/house/map/apt/${dongCode}`);
  }
  fetchHouseAptList(houseInfoId: string) {
    return customAxios.get<HouseInfoListRs>(`/house/list/${houseInfoId}`);
  }
  async fetchHouseDetail(houseOnSaleId?: IdRs) {
    const {
      data: { data },
    } = await customAxios.get<HouseDetailRs>(`house/detail/${houseOnSaleId}`);

    return data;
  }
  fetchHouseOfficetelMap(dongCode: string) {
    return customAxios.get<OfficeMapListRs>(`house/map/officetel/${dongCode}`);
  }
  fetchHouseOfficetelList(houseInfoId: string) {
    return customAxios.get<OfficeHouseListRs>(`house/list/${houseInfoId}`);
  }
}
