import { useRouter } from 'next/router';

import classNames from 'classnames/bind';
import styles from './showList.module.scss';
import { HouseOnSale } from 'src/domain/rs/house/apt/HouseInfoListRs';
import Loading from '@common/loading';
import { useHouseAptList, useHouseAptMap } from '@query/houseQuery';
import { MapVO } from 'src/domain/vo/house/apt/MapListVO';
const cx = classNames.bind(styles);

interface ShowProps {
  selectedData: HouseOnSale[] | undefined;
  selected?: string;
  houseInfoDto: MapVO;
}

const Show = ({ selectedData, selected, houseInfoDto }: ShowProps) => {
  const router = useRouter();

  if (!selectedData?.length) return <div className={cx('noItem')}>매물이 없습니다!</div>;
  return (
    <div className={cx('list_wrapper')}>
      {selectedData.map((item) => {
        return (
          <div key={item.houseInfoId} onClick={() => router.push(`/detail/${item.houseOnSaleId}`)}>
            <div className={cx('houseType')}>{houseInfoDto.houseType === 'APT' ? '아파트' : '오피스텔'}</div>
            <div className={cx('houseName')}>{houseInfoDto.houseName}</div>
            <div className={cx('price')}>
              <span className={cx('selected')}>{selected}</span>
              {item.price >= 10000 ? item.price / 10000 + `억` : item.price + `만원`}
            </div>
            <div className={cx('netLeasableArea')}>
              {Math.floor(item.netLeasableArea)}평 {houseInfoDto.jibueAddress}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default Show;
