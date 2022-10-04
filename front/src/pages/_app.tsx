import 'semantic-ui-css/semantic.min.css';
import 'antd/dist/antd.css';
import App from 'next/app';
import React from 'react';
import Layout from '@common/layout';
import '@styles/reset.scss';
import { QueryClientProvider } from '@tanstack/react-query';
import { queryClient } from '@query/queryClient';

import { Provider, useSelector } from 'react-redux';
import { store } from '../store';

import { PersistGate } from 'redux-persist/integration/react';
import { persistStore } from 'redux-persist';

export let persistor = persistStore(store);

class CustomApp extends App {
  constructor(props: any) {
    super(props);
  }
  render() {
    const { Component, pageProps } = this.props;

    return (
      <Provider store={store}>
        <PersistGate loading={null} persistor={persistor}>
          <QueryClientProvider client={queryClient}>
            <Layout>
              <Component {...pageProps} />
            </Layout>
          </QueryClientProvider>
        </PersistGate>
      </Provider>
    );
  }
}

export default CustomApp;
