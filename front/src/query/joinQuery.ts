import apiStore from '@api';
import { useMutation } from '@tanstack/react-query';
import JoinRq from 'src/domain/rq/join/JoinRq';

export const fetchJoin = async (params: JoinRq) => {
  const { data } = await apiStore.remoteJoinRepo.fetchJoin(params);
  return data;
};

export function useJoin() {
  return useMutation((params: JoinRq) => fetchJoin(params), {
    onSuccess: ({ data }) => {
      alert(data);
      //
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
