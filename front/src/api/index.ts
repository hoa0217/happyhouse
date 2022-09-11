import { RemoteAddressRepo } from './AddressStore';
import { RemoteHouseRepo } from './HouseStore';

const apiStore = {
  remoteAddressRepo: new RemoteAddressRepo(),
  remoteHouseRepo : new RemoteHouseRepo(),
};

export default apiStore;
