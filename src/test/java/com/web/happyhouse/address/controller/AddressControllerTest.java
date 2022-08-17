package com.web.happyhouse.address.controller;

import com.web.happyhouse.address.dto.GugunListDto;
import com.web.happyhouse.address.dto.SidoListDto;
import com.web.happyhouse.address.entity.Gugun;
import com.web.happyhouse.address.entity.Sido;
import com.web.happyhouse.address.repository.GugunRepository;
import com.web.happyhouse.address.repository.SidoRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

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

    @Test
    public void getSidoList() {
        // given
        String url = "http://localhost:" + port + "/address/sido";

        //when
        ResponseEntity<SidoListDto> responseEntity = restTemplate.getForEntity(url, SidoListDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Sido> all = sidoRepository.findAll();
        assertThat(all.size()).isEqualTo(responseEntity.getBody().getSidoDtoList().size());
        System.out.println(responseEntity.getBody().getSidoDtoList());
    }

    @Test
    public void getGugunList() {
        // given
        String url = "http://localhost:" + port + "/address/gugun/11";

        //when
        ResponseEntity<GugunListDto> responseEntity = restTemplate.getForEntity(url, GugunListDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Gugun> bySidoCode = gugunRepository.findBySidoCode("11");
        assertThat(bySidoCode.size()).isEqualTo(responseEntity.getBody().getGugunDtoList().size());
        System.out.println(responseEntity.getBody().getGugunDtoList());
    }
}