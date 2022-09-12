import { RemoteAddressRepo } from './AddressStore';
import { RemoteHouseRepo } from './HouseStore';
import { RemoteLoginRepo } from './LoginStore';

const apiStore = {
  remoteAddressRepo: new RemoteAddressRepo(),
  remoteHouseRepo: new RemoteHouseRepo(),
  remoteLoginRepo: new RemoteLoginRepo(),
};

export default apiStore;
