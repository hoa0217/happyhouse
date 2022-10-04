import React from 'react';
import { Layout as AntdLayout } from 'antd';
import Header from '@common/layout/header';
import { useSelector } from 'react-redux';
import { stateProps } from 'src/store/reducer/loginReducer';

interface LayoutProps {
  children: JSX.Element;
}

const Layout = ({ children }: LayoutProps) => {
  const { Content } = AntdLayout;
  return (
    <AntdLayout>
      <Header />
      <AntdLayout>
        <Content>{children}</Content>
      </AntdLayout>
    </AntdLayout>
  );
};

export default Layout;
