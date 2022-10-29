import { useRouter } from 'next/router';
import { useSelector } from 'react-redux';

const MyPage = () => {
  const { token } = useSelector((state: any) => state.login);
  const router = useRouter();

  if (!token) router.push('/login');
};

export default MyPage;
