import '../styles/globals.css';
import 'semantic-ui-css/semantic.min.css';
import 'antd/dist/antd.css';
import App from 'next/app';
import React from 'react';

class CustomApp extends App {
  constructor(props: any) {
    super(props);
  }
  render() {
    const { Component, pageProps } = this.props;

    return <Component {...pageProps} />;
  }
}

export default CustomApp;
