import React, { useState } from 'react';
import { Select, RadioChangeEvent } from 'antd';

import classNames from 'classnames/bind';
import styles from './showList.module.scss';
import Show from './show';

const { Option } = Select;
const cx = classNames.bind(styles);

const ShowList = ({ houseData, api }: any) => {
  const [selected, setSelected] = useState('매매');
  const houseOnSaleMAEMAEList = houseData?.houseOnSaleMAEMAEList;
  const houseOnSaleJEONSEList = houseData?.houseOnSaleJEONSEList;
  const houseOnSaleWOLSEList = houseData?.houseOnSaleWOLSEList;
  const houseInfoDto = houseData?.houseInfoDto;
  const [selectedData, setSelectedData] = useState(houseOnSaleMAEMAEList);
  const onChange = (event: string) => {
    setSelected(event);

    switch (event) {
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
  };

  return (
    <div className={cx('wrapper')}>
      <div className={cx('items')}>지역목록 {selectedData.length}개</div>
      <div className={cx('recom')}>
        이 지역 추천 매물<img src={'/img/itemList/iconQuestion.png'} height="20px" style={{ marginLeft: '4px' }}></img>
      </div>
      <Select className={cx('selectBar')} onChange={onChange} defaultValue={selected}>
        <Option value={'매매'}>매매</Option>
        <Option value={'전세'}>전세</Option>
        <Option value={'월세'}>월세</Option>
      </Select>
      <Show api={api} selectedData={selectedData} selected={selected} houseInfoDto={houseInfoDto} />
    </div>
  );
};

export default ShowList;
