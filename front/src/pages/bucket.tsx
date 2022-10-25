import { useRouter } from 'next/router';
import { useSelector } from 'react-redux';
import BucketDefault from '@components/bucket';
const Bucket = () => {
  const { token } = useSelector((state: any) => state.login);
  const router = useRouter();

  if (!token) router.push('/login');

  return <BucketDefault />;
};

export default Bucket;
