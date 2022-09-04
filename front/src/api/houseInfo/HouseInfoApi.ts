import { AxiosInstance } from 'axios';
import { HouseInfoDtoType } from 'src/components/detailPage/types/detailPageType';

import customAxios from 'src/utils/axios';

export class HouseInfoApi {
  axios: AxiosInstance = customAxios;
  constructor(axios?: AxiosInstance) {
    if (axios) this.axios = axios;
  }

  getHouseInfoApi = async (id: number | string): Promise<HouseInfoDtoType> => {
    const { data } = await this.axios({
      method: 'GET',
      url: `house/detail/${id}`,
    });
    return data;
  };
}

const houseInfoApi = new HouseInfoApi();

export default houseInfoApi;
