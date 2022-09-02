import useAddressDong from '@query/addresesQuery';

const Test = () => {
  const { data, isLoading } = useAddressDong('11110');

  if (!data || isLoading) return null;

  return <div>{data.dongDtoList[0].dongCode}</div>;
};

export default Test;
