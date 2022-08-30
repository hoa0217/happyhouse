import { MapMarker, useMap } from "react-kakao-maps-sdk";
import React, { useState } from "react";

const EventMarkerContainer = ({ position, content }) => {
    const map = useMap();
    const [isVisible, setIsVisible] = useState(false)

   const markerClick = (marker) => {
    const center = marker.getPosition();

    if (map.getLevel() > 4){
       //map크기가 4보다 크면 확대
      map.setCenter(center);
      map.setLevel(4, {animate : true });
    } else {
    //   //4보다 작으면 이동만
      map.panTo(center);
    } 
   }

    return (
      <MapMarker
        position={position}
        onClick={markerClick}
        onMouseOver={() => setIsVisible(true)}
        onMouseOut={() => setIsVisible(false)}
      >
        {isVisible && content}
      </MapMarker>
    )
  }

  export default EventMarkerContainer;