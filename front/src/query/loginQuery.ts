import apiStore from '@api';
import { useMutation } from '@tanstack/react-query';
import LoginRq from 'src/domain/rq/login/LoginRq';

export const fetchLogin = async (params: LoginRq) => {
  const { data } = await apiStore.remoteLoginRepo.fetchLogin(params);
  return data;
};

export function useLogin() {
  return useMutation((params: LoginRq) => fetchLogin(params), {
    onSuccess: ({ data }) => {
      alert(data);
      //redux
    },
    onError: (error: any) => {
      const {
        response: {
          data: { message },
        },
      } = error;
      alert(message);
    },
  });
}
