import Home from '@components/kaKaoMap';
import { NextPage } from 'next';

const api = 'apt';

const Apart: NextPage = () => {
  return <Home api={api} />;
};

export default Apart;
