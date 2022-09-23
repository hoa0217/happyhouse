import { useState } from 'react';
import { DealTypeRs, HouseDetailDataRs } from 'src/domain/rs/house/detail/HouseDetailRs';

interface useChartDataSetProps {
  deal: DealTypeRs;
  data?: HouseDetailDataRs;
}

export type initType = {
  [key: number | string]: {
    [key: number | string]: {
      price: number;
      cnt: number;
    };
  };
};

const useChartDataSet = ({ deal, data }: useChartDataSetProps) => {
  const fetchData =
    deal === 'JEONSE'
      ? data?.houseDealJEONSEList
      : deal === 'MAEMAE'
      ? data?.houseDealMAEMAEList
      : data?.houseDealWOLSEList;

  const dataSet = fetchData?.reduce((acc, cur) => {
    if (!acc[cur.dealYear]) {
      acc[cur.dealYear] = {};
    }
    if (acc[cur.dealYear] && !acc[cur.dealYear][cur.dealMonth]) {
      acc[cur.dealYear][cur.dealMonth] = {
        cnt: 0,
        price: 0,
      };
    }
    acc[cur.dealYear][cur.dealMonth].cnt += 1;
    acc[cur.dealYear][cur.dealMonth].price += Math.floor(cur.price / acc[cur.dealYear][cur.dealMonth].cnt);
    return acc;
  }, {} as initType);

  const dealYearList = dataSet && Object.keys(dataSet);
  const [selectYear, setSelectYear] = useState(dealYearList?.[0]);
  const labels = selectYear && dataSet && Object.keys(dataSet[selectYear]);
  const priceList =
    selectYear &&
    dataSet &&
    Object.keys(dataSet[selectYear]).map((key) => {
      return dataSet[selectYear][key].price;
    });

  const handleChange = (value: string) => {
    setSelectYear(value);
  };

  return { dealYearList, selectYear, labels, priceList, handleChange, dataSet, fetchData };
};

export default useChartDataSet;
