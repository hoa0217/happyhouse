import { useHouseDetail } from '@query/houseQuery';
import { DetailHeader, DetailWrapper, HouseInfo } from 'src/components/detailPage';

const Detail = () => {
  const { data, isLoading } = useHouseDetail('1');

  if (isLoading) 'loading..';

  return (
    <DetailWrapper>
      <DetailHeader houseName={data?.data.houseInfoDto.houseName} />
      <HouseInfo />
    </DetailWrapper>
  );
};

export default Detail;

/**
 * - detail header
 * - house info
 *      Introduction house
 *      house price info
 * - Nearby facilitiy info
 *      map
 *      nearby facility list
 */
