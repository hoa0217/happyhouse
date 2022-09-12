import Loading from '@common/loading';
import { useAddressDong, useAddressGugun, useAddressSido } from '@query/addresesQuery';
import { useQueries } from '@tanstack/react-query';
import { Spin } from 'antd';
import { NextPage } from 'next';
import React from 'react';
import { KakaoMap } from 'src/components/kaKaoMap';

const Home: NextPage = () => {
  const { data: sidoData, isLoading: isLoadingSido } = useAddressSido();
  const { data: gugunData, isLoading: isLoadingGugun } = useAddressGugun('11');
  const { data: dongData, isLoading: isLoadingDong } = useAddressDong('11110');
  if (isLoadingSido || isLoadingGugun || isLoadingDong) return <Loading />;

  return <KakaoMap sido={sidoData?.sidoDtoList} gugun={gugunData?.gugunDtoList} dong={dongData?.dongDtoList} />;
};

export default Home;
