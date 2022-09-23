import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import { useState } from 'react';
import { DealTypeRs, IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';
import { PriceChart, RealDealList } from '@components/detailPage';
import { useHouseDetail } from '@query/houseQuery';
import { useRouter } from 'next/router';
import useChartDataSet from './useChartDataSet';

const HousePriceInfo = () => {
  const [deal, setDeal] = useState<DealTypeRs>('MAEMAE');

  const {
    query: { id },
  } = useRouter();

  const { data } = useHouseDetail(id as IdRs);
  const { dataSet, dealYearList, selectYear, labels, priceList, handleChange, fetchData } = useChartDataSet({
    deal,
    data,
  });

  return (
    <div className={cx('house_price_info')}>
      <PriceChart priceChartParams={{ dealYearList, selectYear, handleChange, deal, setDeal, priceList, labels }} />

      <RealDealList fetchData={fetchData} deal={deal} />
    </div>
  );
};

export default HousePriceInfo;
