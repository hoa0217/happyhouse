import { Layout as AntdLayout } from 'antd';
import classNames from 'classnames/bind';
import Link from 'next/link';
import styles from './header.module.scss';

const cx = classNames.bind(styles);

const Header = () => {
  const { Header } = AntdLayout;

  return (
    <Header className={cx('header')}>
      <nav className={cx('menu')}>
        <li>
          <Link href="/apart">
            <a role="button">아파트</a>
          </Link>
        </li>
        <li>
          <Link href="/apart">
            <a role="button">오피스텔</a>
          </Link>
        </li>
        <li>
          <Link href="/apart">
            <a role="button">원룸</a>
          </Link>
        </li>
        <li>
          <Link href="/apart">
            <a role="button">투룸</a>
          </Link>
        </li>
      </nav>
    </Header>
  );
};

export default Header;
