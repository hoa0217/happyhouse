import { Html, Head, Main, NextScript } from 'next/document'

export default function Document() {
  return (
    <Html>
      <Head>
        <script type="text/javascript"  src={`//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.API_KEY}&libraries=services,clusterer,drawing`} ></script>
      </Head>
      <body>
        <Main />
        <NextScript />
      </body>
    </Html>
  )
}