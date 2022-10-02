import { Layout as AntdLayout } from 'antd';
import classNames from 'classnames/bind';
import Link from 'next/link';
import { useRouter } from 'next/router';
import styles from './header.module.scss';

const cx = classNames.bind(styles);

const Header = () => {
  const { Header } = AntdLayout;
  const { pathname } = useRouter();

  return (
    <Header className={cx('header')}>
      <div className={cx('content')}>
        <Link href="/">
          <a role="button" className={cx('logo')} />
        </Link>
        {/* menu 영역 */}
        <nav className={cx('menu')}>
          <li className={cx({ isCurrent: pathname === '/apart' })}>
            <Link href="/apart">
              <a role="button">아파트</a>
            </Link>
          </li>
          <li className={cx({ isCurrent: pathname === '/officetel' })}>
            <Link href="/officetel">
              <a role="button">오피스텔</a>
            </Link>
          </li>
          <li className={cx({ isCurrent: pathname === '/oneroom' })}>
            <Link href="/oneroom">
              <a role="button">원룸</a>
            </Link>
          </li>
          <li className={cx({ isCurrent: pathname === '/tworoom' })}>
            <Link href="/tworoom">
              <a role="button">투룸</a>
            </Link>
          </li>
        </nav>
        {/* login 영역 */}
        <div className={cx('login_Wrap')}>
          <Link href="/login">
            <a role="button" className={cx('login')}>
              로그인
            </a>
          </Link>
          <Link href="/">
            <a role="button" className={cx('login')}>
              회원가입
            </a>
          </Link>
        </div>
      </div>
    </Header>
  );
};

export default Header;
