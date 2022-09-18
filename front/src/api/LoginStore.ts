import { AxiosResponse } from 'axios';
import LoginRq from 'src/domain/rq/login/LoginRq';
import LoginRs from 'src/domain/rs/login/LoginRs';
import customAxios from 'src/utils/axios';

export default interface LoginStore {
  fetchLogin(params: LoginRq): Promise<AxiosResponse<LoginRs>>;
}

export class RemoteLoginRepo implements LoginStore {
  fetchLogin(params: LoginRq) {
    return customAxios.post<LoginRs>('login', params);
  }
}
