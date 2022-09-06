import apiStore from "@api"
import { useQuery } from "@tanstack/react-query";
import HouseInfoListVO from "src/domain/vo/house/apt/HouseInfoListVO";
import MapListVO from "src/domain/vo/house/apt/MapListVO";

const keys = ['house','apt']

export const fetchHouseAptMap = async(dongCode: string) => {
    const { data } = await apiStore.remoteHouseRepo.fetchHouseAptMap(dongCode);
    return new MapListVO(data);
}

export const fetchHouseAptList = async(houseInfoId:string) => {
    const { data } = await apiStore.remoteHouseRepo.fetchHouseAptList(houseInfoId);
    return new HouseInfoListVO(data);
}

export function useHouseAptMap(dongCode:string){
    return useQuery([...keys,'map',dongCode], ()=>fetchHouseAptMap(dongCode))
}

export function useHouseAptList(houseInfoId: string) {
    return useQuery([...keys, 'list', houseInfoId], () => fetchHouseAptList(houseInfoId));
}