import classNames from 'classnames/bind';
import { useHouseDetail } from '@query/houseQuery';
import styles from './detailPage.module.scss';
import Image from 'next/image';

const cx = classNames.bind(styles);

const IntroduceHouse = () => {
  const { data, isLoading } = useHouseDetail('1');

  return (
    <div className={cx('introduce_house')}>
      <Image
        src="https://dimg.donga.com/wps/NEWS/IMAGE/2021/12/24/110933500.1.jpg"
        width={393}
        height={180}
        layout="intrinsic"
      />
      <table>
        <tbody>
          <tr>
            <td>건물번호</td>
            <th>{data?.data.houseInfoDto.houseInfoId}</th>
          </tr>
          <tr>
            <td>주소</td>
            <th>{data?.data.houseInfoDto.jibunAddress}</th>
          </tr>
          <tr>
            <td>건물이름</td>
            <th>{data?.data.houseInfoDto.houseName}</th>
          </tr>
          <tr>
            <td>건축년도</td>
            <th>{data?.data.houseInfoDto.buildYear}</th>
          </tr>
          <tr>
            <td>건물유형</td>
            <th>{data?.data.houseInfoDto.houseType}</th>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default IntroduceHouse;
