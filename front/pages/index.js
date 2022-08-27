import React, { useCallback, useEffect, useState } from "react";
import { Map } from "react-kakao-maps-sdk";

import axios from "axios";
import SelectBar from "../components/select.js";
import EventMarkerContainer from "../components/eventMarkerContainer.js";

export default function Home({ sido, gugun, dong }) {

  const [state, setState] = useState({
    center: { lat: 37.5891974378629, lng: 126.969329763593 },
  });
  const [searchAddress, setSearchAddress] = useState();
  const [dongCode, setDongCode] = useState('1111010100');
  const [data, setData] = useState([]);

  const moveMap = () => {
    const geocoder = new kakao.maps.services.Geocoder();

      geocoder.addressSearch(`${searchAddress}`, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
          const newSearch = result[0]
          setState({
            center: { lat: newSearch.y, lng: newSearch.x }
          })
        }
      });
  }


  const searchMap = async() => {
    
    if(!searchAddress) return; //페이지 처음 로드시 실행 방지

    const houseList = [];

    const { data : { houseInfoDtoList } } = await axios.get(`https://happy-haapyhouse.herokuapp.com/house/apt/map/${dongCode}`)
    
    houseInfoDtoList.forEach(house => {
      const geocoder = new kakao.maps.services.Geocoder();

      geocoder.addressSearch(`${house.jibunAddress}`, function(result, status){
        if (status === kakao.maps.services.Status.OK) {
          const newSearch = result[0];
          houseList.push({
            content: <div>{house.houseName}</div>,
            latlng: { lat: newSearch.y, lng: newSearch.x },
          });
          setData([...data,...houseList])
        }
      }); 
    })
    //kakao.maps.services.Status.OK 이거때문에 데이터를 가져오는 시간이 걸리는 걸까?
  }

  // issue
  // useEffect를 사용할때 무조건 로딩시 한번 시작되는가?? [],[param] 상관없이
  // useEffect(()=>{
  //   console.log(4)
  // },[])

  useEffect(() => {
    moveMap();
    searchMap();
  }, [searchAddress]);

  return (
    <>
      <SelectBar
        sido={sido}
        gugun={gugun}
        dong={dong}
        setSearchAddress={setSearchAddress}
        setDongCode={setDongCode}
      />
      <Map
        center={state.center}
        style={{ width: "100vw", height: "100vh" }}
        level={6}
      >
        {
          data.map((value, idx) => (
            <EventMarkerContainer
              key={idx}
              position={value.latlng}
              content={value.content}
            />
          ))
        }
      </Map>
    </>
  );
}

export async function getStaticProps() {
  const res1 = await axios.get(
    "https://happy-haapyhouse.herokuapp.com/address/sido"
  );
  const res2 = await axios.get(
    "https://happy-haapyhouse.herokuapp.com/address/gugun/11"
  );
  const res3 = await axios.get(
    "https://happy-haapyhouse.herokuapp.com/address/dong/11110"
  );

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

