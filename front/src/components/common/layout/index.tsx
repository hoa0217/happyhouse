import classNames from 'classnames/bind';
import React from 'react';
import { Layout as AntdLayout } from 'antd';
import Header from '@common/header';

interface LayoutProps {
  children: JSX.Element;
}

const Layout: React.FC<LayoutProps> = ({ children }) => {
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
