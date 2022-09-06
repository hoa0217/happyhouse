import { useRouter } from "next/router";

import classNames from "classnames/bind";
import styles from './showList.module.scss'

const cx = classNames.bind(styles);

export default function Show({selectedData}){

    const router = useRouter();

    if(!selectedData) return null;

    return (
          <div className={cx('list_wrapper')}>
            {
                selectedData.map((item) => {
                    return (
                        <div key={item.houseInfoId} onClick={() => router.push(`/detail/${item.houseOnSaleId}`)}>
                            <div>욕실 수 : {item.bathCount}</div>
                            <div>해당 층 : {item.floor}층</div>
                            <div>가격 : {item.price >= 10000 ? item.price / 10000 + `억` : item.price + `만원` }</div>
                            <div>주차 가능 수 : {parseInt(item.parkCount)}대</div>
                        </div>
                    )
                })
            }
          </div>
    )
}

