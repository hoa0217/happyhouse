import { useRouter } from "next/router";

import classNames from "classnames/bind";
import styles from './showList.module.scss'
import { HouseOnSale } from "src/domain/rs/house/apt/HouseInfoListRs";
import { HouseOnSaleVO } from "src/domain/vo/house/apt/HouseInfoListVO";
const cx = classNames.bind(styles);

interface ShowProps {
    selectedData : HouseOnSale[] | undefined;
}

const Show = ({selectedData} : ShowProps) => {
    const router = useRouter();

    if(!selectedData?.length) return <div>데이터가 없습니다!</div>
    
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
                            <div>기타 등등...</div>
                        </div>
                    )
                })
            }
          </div>
    )
}

export default Show;

