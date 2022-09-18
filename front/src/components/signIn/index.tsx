import Loading from '@common/loading';
import { useLogin } from '@query/loginQuery';
import { useForm } from 'react-hook-form';
import LoginRq from 'src/domain/rq/login/LoginRq';
import { yupResolver } from '@hookform/resolvers/yup';
import schema from './schema';
import classNames from 'classnames/bind';
import styles from './signIn.module.scss';

const cx = classNames.bind(styles);

const SignIn = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginRq>({ mode: 'onChange', resolver: yupResolver(schema) });

  const { mutate, isLoading } = useLogin();

  const onVaild = (params: LoginRq) => {
    mutate(params);
  };

  if (isLoading) return <Loading></Loading>;

  return (
    <>
      <form onSubmit={handleSubmit(onVaild)}>
        <input {...register('email')} type="text" />
        <span className={cx('error', { visible: errors.email })}>이메일형식이틀렸습니다'</span>
        <input {...register('password')} type="password" />
        <span className={cx('error', { visible: errors.password })}>패스워드형식이틀렸습니다'</span>
        <input type="submit" value="제출" />
      </form>
    </>
  );
};

export default SignIn;
