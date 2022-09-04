import classNames from 'classnames/bind';
import styles from './detailPage.module.scss';
import { ReactNode } from 'react';

const cx = classNames.bind(styles);

interface DetailWrapperProps {
  children: ReactNode;
}

const DetailWrapper = ({ children }: DetailWrapperProps) => {
  return <div className={cx('wrapper')}>{children}</div>;
};

export default DetailWrapper;
