import Loading from '@common/loading';
import { useLogin } from '@query/loginQuery';

const SignIn = () => {
  const { data, isLoading } = useLogin({ email: 'test', password: 'test' });

  if (isLoading) return <Loading></Loading>;

  return <>{console.log(data)}</>;
};

export default SignIn;
