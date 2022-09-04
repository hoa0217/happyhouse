import { useGetHouseInfo } from 'src/api/houseInfo/HouseInfoApi.query';
import { DetailHeader, DetailWrapper, HouseInfo } from 'src/components/detailPage';

const Detail = () => {
  const id = 1; // Todo: id 값을 받아야함 (현재는 test용도)
  const { data, isLoading } = useGetHouseInfo(id);

  console.log('getHouseInfoData :', data);

  if (isLoading) 'loading..';

  return (
    <DetailWrapper>
      <DetailHeader houseName={data?.houseInfoDto.houseName} />
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
