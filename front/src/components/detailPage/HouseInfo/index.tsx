import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import { IntroduceHouse, HousePriceInfo } from '@components/detailPage';

const HouseInfo = () => {
  return (
    <div className={cx('house_info_wrapper')}>
      <IntroduceHouse />
      <HousePriceInfo />
    </div>
  );
};

export default HouseInfo;
