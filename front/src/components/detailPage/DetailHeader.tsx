import classNames from 'classnames/bind';
import styles from './detailPage.module.scss';
const cx = classNames.bind(styles);

import { useHouseDetail } from '@query/houseQuery';
import { useRouter } from 'next/router';
import { IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';

const DetailHeader = () => {
  const {
    query: { id },
  } = useRouter();
  const { data } = useHouseDetail(id as IdRs);
  return (
    <div className={cx('header_wrapper')}>
      {/* <div className={cx('header')}>{data?.data.houseInfoDto.
        houseName}</div> */}
      <div className={cx('header')}>이 세상이 푸르지오</div>
    </div>
  );
};

export default DetailHeader;
