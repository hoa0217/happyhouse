import { Layout as AntdLayout } from 'antd';
import classNames from 'classnames/bind';
import Link from 'next/link';
import styles from './header.module.scss';

const cx = classNames.bind(styles);

const Header = () => {
  const { Header } = AntdLayout;

  return (
    <Header className={cx('header')}>
      <div className={cx('logo')} />
      {/* menu 영역 */}
      <nav className={cx('menu')}>
        <li>
          <Link href="/apart">
            <a role="button">아파트</a>
          </Link>
        </li>
        <li>
          <Link href="/officetel">
            <a role="button">오피스텔</a>
          </Link>
        </li>
        <li>
          <Link href="/oneroom">
            <a role="button">원룸</a>
          </Link>
        </li>
        <li>
          <Link href="/tworoom">
            <a role="button">투룸</a>
          </Link>
        </li>
      </nav>
      {/* login 영역 */}
      <div className={cx('login_Wrap')}>
        <Link href="/login">
          <a role="button" className={cx('login')}>
            Login
          </a>
        </Link>
      </div>
    </Header>
  );
};

export default Header;
