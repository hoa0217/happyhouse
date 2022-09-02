import 'semantic-ui-css/semantic.min.css';
import 'antd/dist/antd.css';
import App from 'next/app';
import React from 'react';
import Layout from '@common/layout';
import '@styles/reset.scss';

class CustomApp extends App {
  constructor(props: any) {
    super(props);
  }
  render() {
    const { Component, pageProps } = this.props;

    return (
      <Layout>
        <Component {...pageProps} />
      </Layout>
    );
  }
}

export default CustomApp;
