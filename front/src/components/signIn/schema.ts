import * as yup from 'yup';

const schema = yup.object().shape({
  email: yup.string().min(3).required(),
  // email: yup.string().email().min(3).required(),

  password: yup.string().min(3).required(),
});

export default schema;
