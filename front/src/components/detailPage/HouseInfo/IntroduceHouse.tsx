import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import Image from 'next/image';
import { useHouseDetail } from '@query/houseQuery';
import { useRouter } from 'next/router';
import { IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';

type tableType = {
  left: string;
  right?: string | number;
};
type tableListType = tableType[];

const IntroduceHouse = () => {
  const {
    query: { id },
  } = useRouter();

  const { data } = useHouseDetail(id as IdRs);

  const tableList: tableListType = [
    { left: '건물번호', right: data?.houseInfoDto.houseInfoId },
    { left: '주소', right: data?.houseInfoDto.jibunAddress },
    { left: '건물이름', right: data?.houseInfoDto.houseName },
    { left: '건축년도', right: data?.houseInfoDto.buildYear },
    { left: '건물유형', right: data?.houseInfoDto.houseType },
  ];

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
          {tableList.map(({ left, right }) => (
            <tr key={`${left}_${right}`}>
              <td>{left}</td>
              <td className={cx('table_right')}>{right}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default IntroduceHouse;
