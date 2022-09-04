import { useQuery } from '@tanstack/react-query';
import houseInfoApi from './HouseInfoApi';

export const DETAIL_API_QUERY_KEY = {
  GET: () => ['houseInfo'],
};

export function useGetHouseInfo(id: string | number) {
  const queryKey = DETAIL_API_QUERY_KEY.GET();
  const query = useQuery(queryKey, () => houseInfoApi.getHouseInfoApi(id), {
    // 5분에 한번 쿼리 날림
    staleTime: 1000 * 60 * 5,
  });

  return { ...query, queryKey };
}
