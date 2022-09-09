package com.web.happyhouse.house.contorller;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.house.domain.HouseType;
import com.web.happyhouse.house.dto.HouseInfoListRs;
import com.web.happyhouse.house.dto.HouseOnSaleDetailRs;
import com.web.happyhouse.house.dto.HouseOnSaleListRs;
import com.web.happyhouse.house.entity.HouseDeal;
import com.web.happyhouse.house.entity.HouseInfo;
import com.web.happyhouse.house.entity.HouseOnSale;
import com.web.happyhouse.house.repository.HouseDealRepository;
import com.web.happyhouse.house.repository.HouseInfoRepository;
import com.web.happyhouse.house.repository.HouseOnSaleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HouseControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DongRepository dongRepository;

    @Autowired
    private HouseInfoRepository houseInfoRepository;

    @Autowired
    private HouseOnSaleRepository houseOnSaleRepository;

    @Autowired
    private HouseDealRepository houseDealRepository;

    @Test
    public void searchAptMap() {

        // given
        String dongCode = "1114017400";
        String url = "http://localhost:" + port + "/house/apt/map/"+dongCode;

        //when
        ResponseEntity<HouseInfoListRs> responseEntity = restTemplate.getForEntity(url, HouseInfoListRs.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Dong byDongCode = dongRepository.findByDongCode(dongCode);
        List<HouseInfo> byDongAndHouseType = houseInfoRepository.findByDongAndHouseType(byDongCode, HouseType.APT);
        assertThat(byDongAndHouseType.size()).isEqualTo(responseEntity.getBody().getHouseInfoDtoList().size());
        System.out.println(responseEntity.getBody().getHouseInfoDtoList());

    }

    @Test
    public void getAptOnSaleList() {

        // given
        Long houseInfoId = 138L;
        String url = "http://localhost:" + port + "/house/apt/list/"+houseInfoId;

        //when
        ResponseEntity<HouseOnSaleListRs> responseEntity = restTemplate.getForEntity(url, HouseOnSaleListRs.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(responseEntity.getBody().getHouseInfoDto().getHouseInfoId()).isEqualTo(houseInfoId);

        HouseInfo houseInfo = houseInfoRepository.findById(houseInfoId).get();
        List<HouseOnSale> byHouseInfo = houseOnSaleRepository.findByHouseInfo(houseInfo);
        int size = responseEntity.getBody().getHouseOnSaleMAEMAEList().size()
                + responseEntity.getBody().getHouseOnSaleJEONSEList().size()
                + responseEntity.getBody().getHouseOnSaleWOLSEList().size();
        assertThat(size).isEqualTo(byHouseInfo.size());

        System.out.println(responseEntity.getBody().getHouseOnSaleMAEMAEList());

    }

    @Test
    public void getOnSaleDetail() {

        // given
        Long houseOnSaleId = 1L;
        String url = "http://localhost:" + port + "/house/detail/"+houseOnSaleId;

        //when
        ResponseEntity<HouseOnSaleDetailRs> responseEntity = restTemplate.getForEntity(url, HouseOnSaleDetailRs.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(responseEntity.getBody().getHouseOnSaleDto().getHouseOnSaleId()).isEqualTo(houseOnSaleId);

        HouseInfo houseInfo = houseInfoRepository.findById(responseEntity.getBody().getHouseInfoDto().getHouseInfoId()).get();
        List<HouseDeal> houseDealList = houseDealRepository.findByHouseInfo(houseInfo);
        int size = responseEntity.getBody().getHouseDealMAEMAEList().size()
                + responseEntity.getBody().getHouseDealJEONSEList().size()
                + responseEntity.getBody().getHouseDealWOLSEList().size();
        assertThat(size).isEqualTo(houseDealList.size());

        System.out.println(responseEntity.getBody().getHouseDealMAEMAEList());

    }

}