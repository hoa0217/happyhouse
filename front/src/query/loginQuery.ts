import apiStore from '@api';
import { useQuery } from '@tanstack/react-query';
import LoginRq from 'src/domain/rq/login/LoginRq';

export const fetchLogin = async (params: LoginRq) => {
  const { data } = await apiStore.remoteLoginRepo.fetchLogin(params);
  return data;
};

export function useLogin(params: LoginRq) {
  return useQuery(['login'], () => fetchLogin(params));
}
