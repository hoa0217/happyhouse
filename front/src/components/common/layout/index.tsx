import classNames from 'classnames/bind';
import React from 'react';
import styles from './layout.module.scss';
const cx = classNames.bind(styles);

interface LayoutProps {
  children: JSX.Element;
}

const Layout: React.FC<LayoutProps> = ({ children }) => {
  return <div className={cx('layout')}>{children}</div>;
};

export default Layout;
