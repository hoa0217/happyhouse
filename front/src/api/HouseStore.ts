import { AxiosResponse } from "axios";
import customAxios from "src/utils/axios";
import MapListRs from "src/domain/rs/house/apt/MapListRs";
import HouseInfoListRs from "src/domain/rs/house/apt/houseInfoListRs";

export default interface HouseStore {
    fetchHouseAptMap(dongCode: string) : Promise<AxiosResponse<MapListRs>>;
    fetchHouseAptList(houseInfoId: string) : Promise<AxiosResponse<HouseInfoListRs>>;
}


export class RemoteHouseRepo implements HouseStore{
    fetchHouseAptMap(dongCode: string){
        return customAxios.get<MapListRs>(`/house/apt/map/${dongCode}`);
    }
    fetchHouseAptList(houseInfoId: string){
        return customAxios.get<HouseInfoListRs>(`/house/apt/list/${houseInfoId}`);
    }
}