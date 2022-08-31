const KakaoMap = () => {
  return (
    <script
      type="text/javascript"
      src={`//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.KAKAO_API_KEY}&libraries=services`}
    />
  );
};

export default KakaoMap;
