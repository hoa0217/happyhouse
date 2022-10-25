import classNames from 'classnames/bind';
import styles from './bucket.module.scss';

const cx = classNames.bind(styles);

const BucketDefault = () => {
  return (
    <div className={cx('bucket_wrapper')}>
      <span className={cx('title')}>관심목록</span>
      <div className={cx('item_Wrapper')}>
        <img src={'img/bucket/iconPrecautions.png'} width="30px" height="30px" style={{ marginLeft: '90px' }} />
        <span className={cx('content')}>관심이 있는 건물이 없습니다.</span>
      </div>
    </div>
  );
};

export default BucketDefault;
