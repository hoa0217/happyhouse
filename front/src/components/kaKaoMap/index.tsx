import Loading from '@common/loading';
import { useAddressDong, useAddressGugun, useAddressSido } from '@query/addresesQuery';
import React from 'react';
import KakaoMap from './KakaoMap';

interface HomeProps {
  api: string;
}

const Home = ({ api }: HomeProps) => {
  const { data: sidoData, isLoading: isLoadingSido } = useAddressSido();
  const { data: gugunData, isLoading: isLoadingGugun } = useAddressGugun('11');
  const { data: dongData, isLoading: isLoadingDong } = useAddressDong('11110');
  if (isLoadingSido || isLoadingGugun || isLoadingDong) return <Loading />;

  return (
    <KakaoMap api={api} sido={sidoData?.sidoDtoList} gugun={gugunData?.gugunDtoList} dong={dongData?.dongDtoList} />
  );
};

export default Home;
