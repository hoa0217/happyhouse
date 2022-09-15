import { RemoteAddressRepo } from './AddressStore';
import { RemoteHouseRepo } from './HouseStore';
import { RemoteJoinRepo } from './JoinStore';
import { RemoteLoginRepo } from './LoginStore';

const apiStore = {
  remoteAddressRepo: new RemoteAddressRepo(),
  remoteHouseRepo: new RemoteHouseRepo(),
  remoteLoginRepo: new RemoteLoginRepo(),
  remoteJoinRepo: new RemoteJoinRepo(),
};

export default apiStore;
