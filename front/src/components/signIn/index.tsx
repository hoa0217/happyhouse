import Loading from '@common/loading';
import { useLogin } from '@query/loginQuery';
import { useForm } from 'react-hook-form';
import LoginRq from 'src/domain/rq/login/LoginRq';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

const SignIn = () => {
  const schema = yup.object().shape({
    email: yup.string().required(),
    password: yup.string().min(3).required(),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginRq>({ mode: 'onChange', resolver: yupResolver(schema) });

  const { mutate, isLoading } = useLogin();

  const onVaild = (params: LoginRq) => {
    mutate(params, {
      onSuccess({ data }) {
        alert(data);
      },
      onError(error: any) {
        const {
          response: {
            data: { message },
          },
        } = error;
        alert(message);
      },
    });
  };

  if (isLoading) return <Loading></Loading>;

  return (
    <>
      <form onSubmit={handleSubmit(onVaild)}>
        <input {...register('email')} type="text" />
        <span>{errors.email && '이메일형식이틀렸습니다'}</span>
        <input {...register('password')} type="password" />
        <span>{errors.password && '패스워드형식이틀렸습니다'}</span>
        <input type="submit" value="제출" />
      </form>
    </>
  );
};

export default SignIn;
