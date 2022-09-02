import Document, { Html, Head, Main, NextScript } from 'next/document';
import React from 'react';
import KakaoMap from '@documents/KaKaoMap';
import GoogleIcon from '@documents/GoogleIcon';

class CustomDocument extends Document {
  render() {
    return (
      <Html lang="ko">
        <Head>
          <GoogleIcon />
          <KakaoMap />
        </Head>
        <body>
          <Main />
          <NextScript />
        </body>
      </Html>
    );
  }
}

export default CustomDocument;
