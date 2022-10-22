import { useRouter } from 'next/router';
import { useSelector } from 'react-redux';

const MyPage = () => {
  const { token } = useSelector((state: any) => state.login);
  const router = useRouter();

  if (!token) router.push('/login');

  return <div>마이페이지</div>;
};

export default MyPage;
