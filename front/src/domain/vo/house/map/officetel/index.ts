import { HouseMapOfficetelRs } from 'src/domain/rs/house/map/officetel';
import { MapVO } from '../../commonVo';

/**
 * @description fetchHouseMapOfficetel에서 houseInfoDataList의 데이터를 핸들링 한 후 리턴해주는 VO
 */
export default class HouseMapOfficetelListVO {
  data: MapVO[];

  constructor(rs: HouseMapOfficetelRs) {
    this.data = rs.data.houseInfoDtoList.map((houseInfoDto) => new MapVO(houseInfoDto));
  }
}
