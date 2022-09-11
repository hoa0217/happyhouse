import { Select } from 'antd';
import axios from 'axios';
import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import { SearchOutlined } from '@ant-design/icons';
import { Button, Tooltip } from 'antd';
import customAxios from 'src/utils/axios';
import { SidoDto } from 'src/domain/rs/adress/SidoListRs';
import { GugunDto } from 'src/domain/rs/adress/GugunListRs';
import { DongDto } from 'src/domain/rs/adress/DongListRs';
const { Option } = Select;

interface SelectBarProps{
  sido : SidoDto[];
  gugun : GugunDto[];
  dong : DongDto[];
  setSearchAddress : Dispatch<SetStateAction<string | undefined>>;
  setDongCode : Dispatch<SetStateAction<string>>;
}


const SelectBar = ({ sido, gugun, dong, setSearchAddress, setDongCode } : SelectBarProps) => {
  const [gugun1, setGugun1] = useState(gugun);
  const [dong1, setDong1] = useState(dong);

  const [sido2, setSido2] = useState('서울특별시');
  const [gugun2, setGugun2] = useState(gugun1[0].gugunName);
  const [dong2, setDong2] = useState(dong1[0].dongName);

  const sidoChange = async (key : string) => {
    const code = key.slice(0, 2);
    const _sido = key.slice(3);
    const res1 = await customAxios.get(`address/gugun/${code}`);
    const res2 = await customAxios.get(`dong/${res1.data.gugunDtoList[0].gugunCode}`);

    setGugun1(res1.data.gugunDtoList);
    setDong1(res2.data.dongDtoList);
    setSido2(_sido);
  };

  const gugunChange = async (key : string) => {
    const code = key.slice(0, 5);
    const _gugun = key.slice(6);
    setGugun2(_gugun);

    const res = await customAxios.get(`address/dong/${code}`);
    setDong1(res.data.dongDtoList);
  };

  const dongChange = (key : string) => {
    const code = key.slice(0, 10);
    const _dong = key.slice(11);
    setDong2(_dong);
    setDongCode(code);
  };

  const setting = () => {
    setSearchAddress(`${sido2} ${gugun2} ${dong2}`);
  };

  useEffect(() => {
    setGugun2(gugun1[0].gugunName);
  }, [gugun1]);

  useEffect(() => {
    setDong2(dong1[0].dongName);
  }, [dong1]);

  return (
    <>
      <Select
        defaultValue={sido2}
        style={{
          width: 180,
        }}
        onChange={sidoChange}
      >
        {sido.map((el) => (
          <Option key={`${el.sidoCode},${el.sidoName}`}>{el.sidoName}</Option>
        ))}
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={gugun2}
        onChange={gugunChange}
      >
        {gugun1.map((el) => (
          <Option key={`${el.gugunCode},${el.gugunName}`}>{el.gugunName}</Option>
        ))}
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={dong2}
        onChange={dongChange}
      >
        {dong1.map((el) => (
          <Option key={`${el.dongCode},${el.dongName}`}>{el.dongName}</Option>
        ))}
      </Select>
      <Tooltip>
        <Button onClick = {setting} shape="circle" icon={<SearchOutlined />} />
      </Tooltip>
    </>
  );
};

export default SelectBar;
