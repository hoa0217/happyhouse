import classNames from 'classnames/bind';
import styles from '@components/detailPage/detailPage.module.scss';
const cx = classNames.bind(styles);

import { Dispatch, SetStateAction } from 'react';
import { DealTypeRs, HouseDetailDataRs, IdRs } from 'src/domain/rs/house/detail/HouseDetailRs';

import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, LineElement, PointElement, LinearScale, Title, CategoryScale, Tooltip } from 'chart.js';
ChartJS.register(LineElement, PointElement, LinearScale, Title, CategoryScale, Tooltip);

import { Select } from 'antd';
const { Option } = Select;

interface priceChartParamsType {
  dealYearList?: string[];
  selectYear?: string;
  labels?: '' | string[];
  priceList?: '' | number[];
  handleChange: (value: string) => void;
  deal: DealTypeRs;
  setDeal: Dispatch<SetStateAction<DealTypeRs>>;
}
interface PriceCharProps {
  priceChartParams: priceChartParamsType;
}

const PriceChart = ({
  priceChartParams: { dealYearList, selectYear, labels, priceList, handleChange, deal, setDeal },
}: PriceCharProps) => {
  const dealList: DealTypeRs[] = ['MAEMAE', 'JEONSE', 'WOLSE'];

  return (
    <div className={cx('chart_container')}>
      <div className={cx('chart_header')}>
        <div className={cx('chart_tab_list')}>
          {dealList.map((dealName, idx) => (
            <div
              className={deal === dealName ? cx(['chart_tab', 'active']) : cx('chart_tab')}
              onClick={() => setDeal(dealName)}
              key={`${dealName}_${idx}`}
            >
              {dealName === 'MAEMAE' ? '매매' : dealName === 'JEONSE' ? '전세' : '월세'}
            </div>
          ))}
        </div>
        <Select defaultValue={selectYear} style={{ width: 120 }} onChange={handleChange}>
          {dealYearList?.map((year, idx) => (
            <Option key={`${year}_${idx}`} value={year}>
              {year}
            </Option>
          ))}
        </Select>
      </div>
      <div className={cx('chart_body')}>
        {labels && priceList && (
          <Line
            data={{
              labels,
              datasets: [
                {
                  backgroundColor: '#ffefea', // point color
                  borderColor: '#ff480d', // line color
                  data: priceList,
                  pointStyle: 'circle', // point style
                  pointRadius: 7, // point size
                  pointHoverRadius: 7, // size when mouse over a circle
                },
              ],
            }}
            options={{
              responsive: true,
              plugins: {},
            }}
          />
        )}
      </div>
    </div>
  );
};

export default PriceChart;
