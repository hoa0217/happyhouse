import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import { useEffect } from 'react';
import { DealTypeRs, houseDealDto } from 'src/domain/rs/house/detail/HouseDetailRs';

interface RealDealListProps {
  fetchData?: houseDealDto[];
  deal: DealTypeRs;
}

const RealDealList = ({ fetchData, deal }: RealDealListProps) => {
  return (
    <div className={cx('real_deal')}>
      <div className={cx('table_container')}>
        <table>
          <thead>
            <tr>
              <td>계약월</td>
              <td>매매가</td>
            </tr>
          </thead>
          <tbody>
            {fetchData?.map((data) => (
              <tr key={data.houseDealId}>
                <td>{`${data.dealYear}.${data.dealMonth}`}</td>
                <td>{data.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default RealDealList;
