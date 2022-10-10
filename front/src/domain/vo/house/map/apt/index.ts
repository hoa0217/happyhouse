import { HouseMapAptRs } from 'src/domain/rs/house/map/apt';
import { MapVO } from '../../commonVo';

/**
 * @description fetchHouseMapApt에서 houseInfoDtoList의 데이터를 핸들링한 후 리턴해주려고 만든 VO
 */
export default class HouseMapAptListVO {
  houseInfoDtoList: MapVO[];

  constructor(rs: HouseMapAptRs) {
    this.houseInfoDtoList = rs.data.houseInfoDtoList.map((houseInfoDto) => new MapVO(houseInfoDto));
  }
}
