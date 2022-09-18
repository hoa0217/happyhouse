import { MapMarker, useMap } from 'react-kakao-maps-sdk';
import React, { DetailedHTMLProps, HTMLAttributes, ReactNode, useState } from 'react';
import axios from 'axios';
import ShowList from './showList/index';
import customAxios from 'src/utils/axios';

interface EventMarkerContainerProps {
  position: positonDto;
  houseInfoId: number;
  api: string;
}

interface positonDto {
  lat: number;
  lng: number;
}

const EventMarkerContainer = ({ position, houseInfoId, api }: EventMarkerContainerProps) => {
  const map = useMap();
  const [houseData, setHouseData] = useState();

  const markerClick = async (marker: any) => {
    const center = marker.getPosition();

    if (map.getLevel() > 4) {
      //map크기가 4보다 크면 확대
      map.setCenter(center);
      map.setLevel(4, { animate: true });
    } else {
      //   //4보다 작으면 이동만
      map.panTo(center);
    }
    const {
      data: { data },
    } = await customAxios.get(`house/${api}/list/${houseInfoId}`); //나중에 주석없애줘야됨!!!
    // const {data : {data}} = await customAxios.get(`house/apt/list/138`);
    setHouseData(data);
  };

  return (
    <>
      <MapMarker position={position} onClick={markerClick}></MapMarker>
      <ShowList houseData={houseData} />
    </>
  );
};

export default EventMarkerContainer;
