import React, { useEffect, useState } from "react";
import { Map, MapMarker,useMap } from "react-kakao-maps-sdk";
import axios from "axios";
import SelectBar from '../components/select.js'

export default function Home({sido,gugun,dong}) {

  const data = [
    {
      content: <div style={{ color: "#000" }}>카카오</div>,
      latlng: { lat: 33.450705, lng: 126.570677 },
    },
    {
      content: <div style={{ color: "#000" }}>생태연못</div>,
      latlng: { lat: 33.450936, lng: 126.569477 },
    },
    {
      content: <div style={{ color: "#000" }}>텃밭</div>,
      latlng: { lat: 33.450879, lng: 126.56994 },
    },
    {
      content: <div style={{ color: "#000" }}>근린공원</div>,
      latlng: { lat: 33.451393, lng: 126.570738 },
    },
  ]

  const EventMarkerContainer = ({ position, content }) => {
    const map = useMap()
    const [isVisible, setIsVisible] = useState(false)

    return (
      <MapMarker
        position={position} // 마커를 표시할 위치
        // @ts-ignore
        onClick={(marker) => map.panTo(marker.getPosition())}
        onMouseOver={() => setIsVisible(true)}
        onMouseOut={() => setIsVisible(false)}
      >
        {isVisible && content}
      </MapMarker>
    )
  }

  return (
    <>
    <SelectBar sido={sido} gugun={gugun} dong={dong} />
        <Map // 지도를 표시할 Container
      center={{
        // 지도의 중심좌표
        lat: 37.51323827179843,
        lng: 127.035686076035,
      }}
      style={{
        // 지도의 크기
        width: "100vw",
        height: "100vh",
      }}
      level={7} // 지도의 확대 레벨
    >
      {data.map((value) => (
        <EventMarkerContainer
          key={`EventMarkerContainer-${value.latlng.lat}-${value.latlng.lng}`}
          position={value.latlng}
          content={value.content}
        />
      ))}
    </Map>
    </>
  );
}

export async function getStaticProps(){
  const res1 = await axios.get('https://happy-haapyhouse.herokuapp.com/address/sido');
  const res2 = await axios.get('https://happy-haapyhouse.herokuapp.com/address/gugun/11');
  const res3 = await axios.get('https://happy-haapyhouse.herokuapp.com/address/dong/11110');

  const sido = res1.data.sidoDtoList;
  const gugun = res2.data.gugunDtoList;
  const dong = res3.data.dongDtoList;
  return {
    props: {
      sido: sido,
      gugun: gugun,
      dong : dong,
    },
  }
}

