import apiStore from '@api';
import { useMutation } from '@tanstack/react-query';
import { useRouter } from 'next/router';
import { useDispatch } from 'react-redux';
import LoginRq from 'src/domain/rq/login/LoginRq';
import { setToken } from 'src/store/reducer/loginReducer';

export const fetchLogin = async (params: LoginRq) => {
  const { data } = await apiStore.remoteLoginRepo.fetchLogin(params);
  return data;
};

export function useLogin() {
  const dispatch = useDispatch();
  const router = useRouter();
  return useMutation((params: LoginRq) => fetchLogin(params), {
    onSuccess: ({ data }) => {
      dispatch(
        setToken({
          token: data,
        }),
      );
      router.push('/apart');
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
