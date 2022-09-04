import classNames from 'classnames/bind';
import React from 'react';
import styles from './detailPage.module.scss';

const cx = classNames.bind(styles);

interface DetailHeaderProps {
  houseName?: string;
}

const DetailHeader = ({ houseName }: DetailHeaderProps) => {
  return (
    <div className={cx('header_wrapper')}>
      <div className={cx('header')}>{houseName}</div>
    </div>
  );
};

export default DetailHeader;
