import { MapMarker, useMap } from "react-kakao-maps-sdk";
import React, { useState } from "react";
import axios from "axios";

import ShowList from "./showList.js";

const EventMarkerContainer = ({ position, content, houseInfoId }) => {
    const map = useMap();
    const [isVisible, setIsVisible] = useState(false);
    const [houseData, setHouseData] = useState();

   const markerClick = async(marker) => {
    const center = marker.getPosition();

    if (map.getLevel() > 4){
       //map크기가 4보다 크면 확대
      map.setCenter(center);
      map.setLevel(4, {animate : true });
    } else {
    //   //4보다 작으면 이동만
      map.panTo(center);
    }
    // const res = await axios.get(`https://happy-haapyhouse.herokuapp.com/house/apt/list/${houseInfoId}`);
    const res = await axios.get(`https://happy-haapyhouse.herokuapp.com/house/apt/list/138`);
    setHouseData(res);
   }

    return (
      <>
        <MapMarker
          position={position}
          onClick={markerClick}
          onMouseOver={() => setIsVisible(true)}
          onMouseOut={() => setIsVisible(false)} >
          {isVisible && content}
        </MapMarker>
        <ShowList houseData={houseData}/>
      </>
    )
  }

  export default EventMarkerContainer;