import Home from '@components/kaKaoMap';
import { NextPage } from 'next';

const api = 'apt';

const OneRoom: NextPage = () => {
  return <Home api={api} />;
};

export default OneRoom;
