import React from 'react';
import { AppProps } from 'next/app';

import 'semantic-ui-css/semantic.min.css';
import 'antd/dist/antd.css';
import '@styles/reset.scss';

import { queryClient as DefaultQueryClient } from '@query/queryClient';
import { Hydrate, QueryClientProvider } from '@tanstack/react-query';

import { Provider } from 'react-redux';
import { persistStore } from 'redux-persist';
import { PersistGate } from 'redux-persist/integration/react';
import { store } from '../store';

import Layout from '@common/layout';

export const persistor = persistStore(store);

export default function MyApp({ Component, pageProps }: AppProps) {
  const [queryClient] = React.useState(() => DefaultQueryClient);

  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <QueryClientProvider client={queryClient}>
          <Hydrate state={pageProps.dehydratedState}>
            <Layout>
              <Component {...pageProps} />
            </Layout>
          </Hydrate>
        </QueryClientProvider>
      </PersistGate>
    </Provider>
  );
}
