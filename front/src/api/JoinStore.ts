import { AxiosResponse } from 'axios';
import JoinRq from 'src/domain/rq/join/JoinRq';
import JoinRs from 'src/domain/rs/join/JoinRs';
import customAxios from 'src/utils/axios';

export default interface JoinStore {
  fetchJoin(params: JoinRq): Promise<AxiosResponse<JoinRs>>;
}

export class RemoteJoinRepo implements JoinStore {
  fetchJoin(params: JoinRq) {
    return customAxios.post<JoinRs>('join', params);
  }
}
