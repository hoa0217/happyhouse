import { useQueryClient } from '@tanstack/react-query';
import classNames from 'classnames/bind';
import { HouseInfoDtoType } from './types/detailPageType';
import styles from './detailPage.module.scss';
import Image from 'next/image';

const cx = classNames.bind(styles);

const IntroduceHouse = () => {
  const queryClient = useQueryClient();
  const houseInfo = queryClient.getQueryData<HouseInfoDtoType>(['houseInfo'])?.houseInfoDto;

  return (
    <div className={cx('introduce_house')}>
      <Image
        src="https://dimg.donga.com/wps/NEWS/IMAGE/2021/12/24/110933500.1.jpg"
        width={393}
        height={180}
        layout="intrinsic"
      />
    </div>
  );
};

export default IntroduceHouse;
