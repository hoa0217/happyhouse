import { RemoteAddressRepo } from './AddressStore';
import { RemoteHouseRepo } from './HouseStore';
import { RemoteJoinRepo } from './JoinStore';
import { RemoteLoginRepo } from './LoginStore';
import { RemoteVillaRepo } from './VillaStore';

const apiStore = {
  remoteAddressRepo: new RemoteAddressRepo(),
  remoteHouseRepo: new RemoteHouseRepo(),
  remoteLoginRepo: new RemoteLoginRepo(),
  remoteJoinRepo: new RemoteJoinRepo(),
  remoteVillaRepo: new RemoteVillaRepo(),
};

export default apiStore;
