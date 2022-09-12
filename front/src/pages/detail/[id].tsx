import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import { GetServerSideProps } from 'next';
import { useHouseDetail } from '@query/houseQuery';
import { DetailHeader, HouseInfo } from '@components/detailPage';
import { IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';
import { AxiosError } from 'axios';
import { useRouter } from 'next/router';
import customAxios from 'src/utils/axios';
import apiStore from '@api';

interface DetailProps {
  id: IdRs;
}

const Detail = ({ id }: DetailProps) => {
  console.log('component test :', id);

  const { isLoading, isError, error } = useHouseDetail(id);

  if (isLoading) return 'loading..';
  if (isError) {
    let axiosError = error as AxiosError;
    return `${axiosError.message}`;
  }

  return (
    <div className={cx('wrapper')}>
      <DetailHeader />
      <HouseInfo />
    </div>
  );
};

export default Detail;

export const getServerSideProps: GetServerSideProps = async (context) => {
  const {
    query: { id },
  } = context;

  console.log('serverside test : ', id);

  return {
    props: {
      id,
    },
  };
};

/**
 * - detail header
 * - house info
 *      Introduction house
 *      house price info
 * - Nearby facilitiy info
 *      map
 *      nearby facility list
 */
