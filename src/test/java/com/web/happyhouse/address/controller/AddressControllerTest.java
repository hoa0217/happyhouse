package com.web.happyhouse.address.controller;

import com.web.happyhouse.address.entity.Dong;
import com.web.happyhouse.address.entity.Gugun;
import com.web.happyhouse.address.entity.Sido;
import com.web.happyhouse.address.repository.DongRepository;
import com.web.happyhouse.address.repository.GugunRepository;
import com.web.happyhouse.address.repository.SidoRepository;
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
public class AddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SidoRepository sidoRepository;

    @Autowired
    private GugunRepository gugunRepository;

    @Autowired
    private DongRepository dongRepository;

//    @Test
//    public void getSidoList() {
//        // given
//        String url = "http://localhost:" + port + "/address/sido";
//
//        //when
//        ResponseEntity<SidoListDto> responseEntity = restTemplate.getForEntity(url, SidoListDto.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        List<Sido> all = sidoRepository.findAll();
//        assertThat(all.size()).isEqualTo(responseEntity.getBody().getSidoDtoList().size());
//        System.out.println(responseEntity.getBody().getSidoDtoList());
//    }
//
//    @Test
//    public void getGugunList() {
//        // given
//        String url = "http://localhost:" + port + "/address/gugun/11";
//
//        //when
//        ResponseEntity<GugunListDto> responseEntity = restTemplate.getForEntity(url, GugunListDto.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        List<Gugun> bySidoCode = gugunRepository.findBySidoCode("11");
//        assertThat(bySidoCode.size()).isEqualTo(responseEntity.getBody().getGugunDtoList().size());
//        System.out.println(responseEntity.getBody().getGugunDtoList());
//    }
//
//    @Test
//    public void getDongList(){
//        // given
//        String url = "http://localhost:" + port + "/address/dong/11350";
//
//        //when
//        ResponseEntity<DongListDto> responseEntity = restTemplate.getForEntity(url, DongListDto.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        List<Dong> byGugunCode = dongRepository.findBySidoCodeAndGugunCode("11","11350");
//        assertThat((byGugunCode.size())).isEqualTo(responseEntity.getBody().getDongDtoList().size());
//        System.out.println(responseEntity.getBody().getDongDtoList());
//    }
}