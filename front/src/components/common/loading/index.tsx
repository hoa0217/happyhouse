import { Spin } from 'antd';
import classNames from 'classnames/bind';
import styles from './loading.module.scss';

const cx = classNames.bind(styles);

const Loading = () => {
  return (
    <div className={cx('loading')}>
      <Spin tip="Loading..." />
    </div>
  );
};

export default Loading;
