import { useEffect, useState } from "react";
import Select from "../components/select.js";
import axios from "axios";

export default function Home({ list }) {
  const [geo, setGeo] = useState(["서울시"]);
  const [map, setMap] = useState("");

  return (
    <>
      <button onClick={moveGeo}>search</button>
      <Map // 지도를 표시할 Container
      center={{
        // 지도의 중심좌표
        lat: 33.450701,
        lng: 126.570667,
      }}
      style={{
        // 지도의 크기
        width: "100%",
        height: "450px",
      }}
      level={3} // 지도의 확대 레벨
    />
    </>
  );
}

export async function getStaticProps() {
  const res = await axios.get(
    "https://new.land.naver.com/api/regions/list?cortarNo=0000000000"
  );
  const regionList = res.data.regionList;

  return {
    props: {
      list: regionList,
    },
  };
}
