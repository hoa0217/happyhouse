import 'semantic-ui-css/semantic.min.css';
import 'antd/dist/antd.css';
import App from 'next/app';
import React from 'react';
import Layout from '@common/layout';
import '@styles/reset.scss';
import { QueryClientProvider } from '@tanstack/react-query';
import { queryClient } from '@query/queryClient';

class CustomApp extends App {
  constructor(props: any) {
    super(props);
  }
  render() {
    const { Component, pageProps } = this.props;

    return (
      <QueryClientProvider client={queryClient}>
        <Layout>
          <Component {...pageProps} />
        </Layout>
      </QueryClientProvider>
    );
  }
}

export default CustomApp;
