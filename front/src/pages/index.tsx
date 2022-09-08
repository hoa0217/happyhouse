import React, { useEffect, useState } from 'react';
import { Map } from 'react-kakao-maps-sdk';

import EventMarkerContainer from 'src/components/kaKaoMap/mapMarker';
import SelectBar from 'src/components/kaKaoMap/select';
import customAxios from 'src/utils/axios';
import { DongDto } from 'src/domain/rs/adress/DongListRs';
import { SidoDto } from 'src/domain/rs/adress/SidoListRs';
import { GugunDto } from 'src/domain/rs/adress/GugunListRs';
import { houseInfoDto } from 'src/domain/rs/house/apt/MapListRs';


interface KakaoMapProps {
  dong: DongDto[];
  sido: SidoDto[];
  gugun: GugunDto[];
}

interface mapCenter {
  center: centerDto;
}

interface centerDto {
  lat: number;
  lng: number;
}

export default function KakaoMap({ sido, gugun, dong }: KakaoMapProps) {
  const [state, setState] = useState<mapCenter>({
    center: { lat: 37.5891974378629, lng: 126.969329763593 },
  });
  const [searchAddress, setSearchAddress] = useState<string>();
  const [dongCode, setDongCode] = useState<string>('1111010100');
  const [homes, setHomes] = useState<any[]>([]);
  const [dongList, setDongList] = useState<any[]>([]);


  const moveMap = () => {
    const geocoder = new kakao.maps.services.Geocoder();

    geocoder.addressSearch(`${searchAddress}`, function (result, status) {
      if (status === kakao.maps.services.Status.OK) {
        const newSearch = result[0];
        setState({
          center: { lat: Number(newSearch.y), lng: Number(newSearch.x) },
        });
      }
    });
  };

  const searchMap = async () => {
    if (!searchAddress) return; //페이지 처음 로드시 실행 방지

    const houseList : any[] = [];

    const {
      data: { houseInfoDtoList },
    } = await customAxios.get(`house/apt/map/${dongCode}`);

    

    if (!houseInfoDtoList.length) return; //매물이 없는 경우 종료

    const isCode = houseInfoDtoList[0].dongCode;

    //이미 찾았던 동 찾을 시 종료
    if (isCode){
      if(dongList.findIndex(code => code === isCode) !== -1) return;//이미찾은 데이터는 종료
      setDongList([...dongList,isCode]) //동 리스트에 동 저장
    }

    houseInfoDtoList.forEach((house : houseInfoDto) => {
      const geocoder = new kakao.maps.services.Geocoder();

      geocoder.addressSearch(`${house.jibunAddress}`, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          const newSearch = result[0];
          houseList.push({
            content: <div>{house.houseName}</div>,
            latlng: { lat: newSearch.y, lng: newSearch.x },
            houseInfoId : house.houseInfoId,
          });
          setHomes([...homes, ...houseList]);
        }
      });
    });
  };

  useEffect(() => {
    moveMap();
    searchMap();
  }, [searchAddress]);

  return (
    <>
      <SelectBar sido={sido} gugun={gugun} dong={dong} setSearchAddress={setSearchAddress} setDongCode={setDongCode} />
      <Map center={state.center} style={{ width: '100%', height: '88vh' }} level={6}>
        {homes.map((value, idx) => (
          <EventMarkerContainer key={idx} position={value.latlng} content={value.content} houseInfoId={value.houseInfoId}
          />
        ))}
      </Map>
      
    </>
  );
}

export async function getStaticProps() {
  const res1 = await customAxios.get('address/sido');
  const res2 = await customAxios.get('address/gugun/11');
  const res3 = await customAxios.get('address/dong/11110');
  const sido = res1.data.sidoDtoList;
  const gugun = res2.data.gugunDtoList;
  const dong = res3.data.dongDtoList;

  return {
    props: {
      sido,
      gugun,
      dong,
    },
  };
}
