import classNames from 'classnames/bind';
import styles from './detailPage.module.scss';
import IntroduceHouse from './IntroduceHouse';

const cx = classNames.bind(styles);

const HouseInfo = () => {
  return (
    <div className={cx('house_info_wrapper')}>
      <IntroduceHouse />
      <div className={cx('house_price_info')}></div>
    </div>
  );
};

export default HouseInfo;
