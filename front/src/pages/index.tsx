import { useAddressDong, useAddressGugun, useAddressSido } from "@query/addresesQuery";
import { NextPage } from "next";
import React from "react";
import { KakaoMap, KakaoMapWrapper } from "src/components/kaKaoMap";

const Home : NextPage  = () => {

  const fetchSido = useAddressSido();
  const fetchGugun = useAddressGugun('11');
  const fetchDong = useAddressDong('11110');

  if (fetchDong.isLoading  || 
        fetchGugun.isLoading || 
          fetchDong.isLoading) return <div>Loading...</div>

  return (
    <KakaoMapWrapper>
      <KakaoMap 
        sido = {fetchSido.data?.sidoDtoList} 
        gugun = {fetchGugun.data?.gugunDtoList} 
        dong = {fetchDong.data?.dongDtoList}
      />
    </KakaoMapWrapper>
  )
}

export default Home;
