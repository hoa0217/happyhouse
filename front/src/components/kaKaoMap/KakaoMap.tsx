import React, { DetailedHTMLProps, HTMLAttributes, ReactNode, useEffect, useState } from 'react';
import { Map, MapTypeControl, ZoomControl } from 'react-kakao-maps-sdk';

import EventMarkerContainer from 'src/components/kaKaoMap/mapMarker';
import SelectBar from 'src/components/kaKaoMap/select';
import customAxios from 'src/utils/axios';
import { houseInfoDto } from 'src/domain/rs/house/apt/MapListRs';
import { GugunVO } from 'src/domain/vo/adress/GugunListVO';
import { SidoVO } from 'src/domain/vo/adress/SidoListVO';
import { DongVO } from 'src/domain/vo/adress/DongListVO';
import moveMap from './utils/moveMap';
import Loading from '@common/loading';

interface KakaoMapProps {
  dong?: DongVO[];
  sido?: SidoVO[];
  gugun?: GugunVO[];
  api: string;
}

export interface mapCenter {
  center: centerDto;
}

interface centerDto {
  lat: number;
  lng: number;
}

interface homesProps {
  houseInfoId: number;
  latlng: centerDto;
}

const KakaoMap = ({ sido, gugun, dong, api }: KakaoMapProps) => {
  const [state, setState] = useState<mapCenter>({
    center: { lat: 37.5891974378629, lng: 126.969329763593 },
  });
  const [searchAddress, setSearchAddress] = useState<string | undefined>('');
  const [dongCode, setDongCode] = useState<string>('1111010100');
  const [homes, setHomes] = useState<homesProps[]>([]);
  const [dongList, setDongList] = useState<string[]>([]);
  const [isSearch, setIsSearch] = useState(false);
  const searchMap = async () => {
    if (!searchAddress) return; //페이지 처음 로드시 실행 방지

    setIsSearch(true);
    const houseList: homesProps[] = [];

    const {
      data: {
        data: { houseInfoDtoList },
      },
    } = await customAxios.get(`house/map/${api}/${dongCode}`);

    if (!houseInfoDtoList.length) {
      setIsSearch(false);
      return; //매물이 없는 경우 종료
    }
    const isCode = houseInfoDtoList[0].dongCode;

    //이미 찾았던 동 찾을 시 종료
    if (isCode) {
      if (dongList.findIndex((code) => code === isCode) !== -1) {
        setIsSearch(false);
        return;
      } //이미찾은 데이터는 종료
      setDongList([...dongList, isCode]); //동 리스트에 동 저장
    }

    houseInfoDtoList.forEach((house: houseInfoDto) => {
      const geocoder = new kakao.maps.services.Geocoder();

      geocoder.addressSearch(`${house.jibunAddress}`, (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          const newSearch = result[0];
          houseList.push({
            latlng: { lat: Number(newSearch.y), lng: Number(newSearch.x) },
            houseInfoId: house.houseInfoId,
          });
          setHomes([...homes, ...houseList]);
        }
      });
    });

    setIsSearch(false);
  };

  useEffect(() => {
    moveMap({ searchAddress, setState });
    searchMap();
  }, [searchAddress]);

  return (
    <>
      <SelectBar sido={sido} gugun={gugun} dong={dong} setSearchAddress={setSearchAddress} setDongCode={setDongCode} />
      {isSearch && <Loading></Loading>}
      <Map center={state.center} style={{ width: '100%', height: '86vh' }} level={4}>
        {homes.map((value, idx) => (
          <EventMarkerContainer key={idx} api={api} position={value.latlng} houseInfoId={value.houseInfoId} />
        ))}
        <ZoomControl position={kakao.maps.ControlPosition.BOTTOMRIGHT} />
        <MapTypeControl position={kakao.maps.ControlPosition.TOPRIGHT} />
      </Map>
    </>
  );
};

export default KakaoMap;
