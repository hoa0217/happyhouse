import { MapMarker, useMap } from 'react-kakao-maps-sdk';
import React, { ReactNode, useState } from 'react';
import axios from 'axios';
import ShowList from './showList/index';
import customAxios from 'src/utils/axios';

interface EventMarkerContainerProps {
  position : positonDto;
  content : ReactNode;
  houseInfoId : number;
}

interface positonDto {
  lat : number;
  lng : number;
}


const EventMarkerContainer = ({ position, content, houseInfoId } : EventMarkerContainerProps) => {
  const map = useMap();
  const [isVisible, setIsVisible] = useState<Boolean>(false);
  const [houseData, setHouseData] = useState<any>();

  const markerClick = async (marker : any) => {
    const center = marker.getPosition();

    if (map.getLevel() > 4) {
      //map크기가 4보다 크면 확대
      map.setCenter(center);
      map.setLevel(4, { animate: true });
    } else {
      //   //4보다 작으면 이동만
      map.panTo(center);
    }
    // const res = await customAxios.get(`apt/list/${houseInfoId}`);//나중에 주석없애줘야됨!!!
    const res = await customAxios.get(`house/apt/list/138`);
    setHouseData(res);
  };

  return (
    <>
      <MapMarker
        position={position}
        onClick={markerClick}
        onMouseOver={() => setIsVisible(true)}
        onMouseOut={() => setIsVisible(false)}
      >
        {isVisible && content}
      </MapMarker>
      <ShowList houseData={houseData} />
    </>
  );
};

export default EventMarkerContainer;
