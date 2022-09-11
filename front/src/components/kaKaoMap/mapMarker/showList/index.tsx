import React, { ChangeEvent, useState } from 'react';
import { Radio, RadioChangeEvent } from 'antd';
import classNames from 'classnames/bind';
import styles from './showList.module.scss'
import Show from './show';

const cx = classNames.bind(styles);

const ShowList = ({ houseData} : any) => {
  if (!houseData) return null; //처음실행할때 undefined 방지

  const [selected, setSelected] = useState('매매');
  const {
    data: { houseOnSaleJEONSEList, houseOnSaleMAEMAEList, houseOnSaleWOLSEList },
  } = houseData;
  const [selectedData, setSelectedData] = useState(houseOnSaleMAEMAEList)
  const onChange = (e : RadioChangeEvent) => {
    setSelected(e.target.value);

    switch (e.target.value) {
      case '매매':
        setSelectedData(houseOnSaleMAEMAEList);
        break;
      case '전세':
        setSelectedData(houseOnSaleJEONSEList);
      break;
      case '월세':
        setSelectedData(houseOnSaleWOLSEList);
      break;
    }
  }

  return (
    <div className={cx('wrapper')}>
      <Radio.Group onChange={onChange} value={selected}>
        <Radio value={'매매'}>매매</Radio>
        <Radio value={'전세'}>전세</Radio>
        <Radio value={'월세'}>월세</Radio>
      </Radio.Group>
      <Show selectedData={selectedData}/>
    </div>
  );
}

export default ShowList