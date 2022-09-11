import { Dispatch, SetStateAction } from "react";
import { mapCenter } from "../KakaoMap";

interface moveMapProps{
    searchAddress ?: string;
    setState : Dispatch<SetStateAction<mapCenter>>
  }

const moveMap = ({searchAddress, setState} : moveMapProps) => {
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

  export default moveMap;