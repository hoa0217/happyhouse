import { Select } from "antd";
import axios from "axios";
import React, { useEffect, useState } from "react";
const { Option } = Select;


const SelectBar = ({sido, gugun, dong}) => {

  const [gugun1, setGugun1] = useState(gugun);
  const [dong1, setDong1] = useState(dong);

  const [gugun2, setGugun2] = useState(gugun1[0].gugunName);
  const [dong2, setDong2] = useState(dong1[0].dongName);

  const sidoChange = async(code) => {
    const res1 = await axios.get(`https://happy-haapyhouse.herokuapp.com/address/gugun/${code}`);
    const res2 = await axios.get(`https://happy-haapyhouse.herokuapp.com/address/dong/${res1.data.gugunDtoList[0].gugunCode}`);
    
    setGugun1(res1.data.gugunDtoList);
    setDong1(res2.data.dongDtoList);
  }

  const gugunChange = async(key) => {
    const code = key.slice(0,5);
    const _gugun = key.slice(6);
    setGugun2(_gugun);

    const res = await axios.get(`https://happy-haapyhouse.herokuapp.com/address/dong/${code}`);
    setDong1(res.data.dongDtoList);
  }
  
  const dongChange = (name) => {
    setDong2(name);
  }

  useEffect(()=>{
    setGugun2(gugun1[0].gugunName);
  },[gugun1])

  useEffect(()=>{
    setDong2(dong1[0].dongName);
  },[dong1])

  return (
    <>
      <Select
        defaultValue={'서울특별시'}
        style={{
          width: 180,
        }}
        onChange={sidoChange}
      >
        {
          sido.map((el) => (
            <Option key={el.sidoCode}>{el.sidoName}</Option>
          ))
        }
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={gugun2}
        onChange={gugunChange}
      >
        {
          gugun1.map((el) => (
            <Option key={`${el.gugunCode},${el.gugunName}`}>{el.gugunName}</Option>))
        }
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={dong2}
        onChange={dongChange}
      >
        {
          dong1.map((el) => (
            <Option key={el.dongName}>{el.dongName}</Option>))
        }
      </Select>
    </>
  );
};

export default SelectBar;
