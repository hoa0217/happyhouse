import { Select } from 'antd';
import React, { Dispatch, SetStateAction, useEffect, useState } from 'react';
import { SearchOutlined } from '@ant-design/icons';
import { Button, Tooltip } from 'antd';
import customAxios from 'src/utils/axios';
import { GugunVO } from 'src/domain/vo/adress/GugunListVO';
import { DongVO } from 'src/domain/vo/adress/DongListVO';
import { SidoVO } from 'src/domain/vo/adress/SidoListVO';
import classNames from 'classnames/bind';
import styles from './select.module.scss';

const cx = classNames.bind(styles);
const { Option } = Select;

interface SelectBarProps {
  sido: SidoVO[] | undefined;
  gugun: GugunVO[] | undefined;
  dong: DongVO[] | undefined;
  setSearchAddress: Dispatch<SetStateAction<string | undefined>>;
  setDongCode: Dispatch<SetStateAction<string>>;
}

const SelectBar = ({ sido, gugun, dong, setSearchAddress, setDongCode }: SelectBarProps) => {
  const [gugun1, setGugun1] = useState(gugun);
  const [dong1, setDong1] = useState(dong);

  const [sido2, setSido2] = useState<string>('서울특별시');
  const [gugun2, setGugun2] = useState<string | undefined>(gugun1?.[0].gugunName);
  const [dong2, setDong2] = useState<string | undefined>(dong1?.[0].dongName);

  const sidoChange = async (key: string) => {
    const code = key.slice(0, 2);
    const _sido = key.slice(3);
    const res1 = await customAxios.get(`address/gugun/${code}`);
    const res2 = await customAxios.get(`address/dong/${res1.data.data[0].gugunCode}`);
    setGugun1(res1.data.data);
    setDong1(res2.data.data);
    setSido2(_sido);
  };

  const gugunChange = async (key: string) => {
    const code = key.slice(0, 5);
    const _gugun = key.slice(6);
    setGugun2(_gugun);

    const {
      data: { data },
    } = await customAxios.get(`address/dong/${code}`);
    setDong1(data);
  };

  const dongChange = (key: string) => {
    const code = key.slice(0, 10);
    const _dong = key.slice(11);
    setDong2(_dong);
    setDongCode(code);
  };

  const setting = () => {
    setSearchAddress(`${sido2} ${gugun2} ${dong2}`);
  };

  useEffect(() => {
    setGugun2(gugun1?.[0].gugunName);
  }, [gugun1]);

  useEffect(() => {
    setDong2(dong1?.[0].dongName);
  }, [dong1]);

  return (
    <div className={cx('select_wrapper')}>
      <Select
        defaultValue={sido2}
        style={{
          width: 180,
        }}
        onChange={sidoChange}
        className={cx('select_item')}
      >
        {sido?.reverse().map((el) => (
          <Option key={`${el.sidoCode},${el.sidoName}`}>{el.sidoName}</Option>
        ))}
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={gugun2}
        onChange={gugunChange}
        className={cx('select_item')}
      >
        {gugun1?.map((el) => (
          <Option key={`${el.gugunCode},${el.gugunName}`}>{el.gugunName}</Option>
        ))}
      </Select>

      <Select
        style={{
          width: 180,
        }}
        value={dong2}
        onChange={dongChange}
        className={cx('select_item')}
      >
        {dong1?.map((el) => (
          <Option key={`${el.dongCode},${el.dongName}`}>{el.dongName}</Option>
        ))}
      </Select>
      <Tooltip>
        <Button onClick={setting} shape="circle" icon={<SearchOutlined />} />
      </Tooltip>
    </div>
  );
};

export default SelectBar;
