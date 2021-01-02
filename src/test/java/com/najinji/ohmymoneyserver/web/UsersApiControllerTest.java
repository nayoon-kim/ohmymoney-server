package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.domain.users.Users;
import com.najinji.ohmymoneyserver.domain.users.UsersRepository;
import com.najinji.ohmymoneyserver.web.dto.UsersSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.UsersUpdateRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @After
    public void tearDown() throws Exception {
        usersRepository.deleteAll();
    }

    @Test
    public void Users_등록된다() throws Exception {

        //given
        String name = "나윤";
        String loginname = "nayoon";
        String password = "pwnayoon";
        int gender = 1;
        int age = 25;

        UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
                .name(name)
                .loginname(loginname)
                .password(password)
                .gender(gender)
                .age(age)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getLoginname()).isEqualTo(loginname);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
        assertThat(all.get(0).getGender()).isEqualTo(gender);
        assertThat(all.get(0).getAge()).isEqualTo(age);
    }

    @Test
    public void Users_수정된다() throws Exception {
        //given
        Users savedUsers = usersRepository.save(Users.builder()
                .name("김나윤")
                .loginname("nayoon")
                .password("pwnayoon")
                .gender(0)
                .age(24)
                .build());

        Long updateId = savedUsers.getId();
        String expectedPassword = "pwnayoon1";
        int expectedGender = 1;
        int expectedAge = 25;

        UsersUpdateRequestDto requestDto = UsersUpdateRequestDto.builder()
                .password(expectedPassword)
                .gender(expectedGender)
                .age(expectedAge)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users/" + updateId;

        HttpEntity<UsersUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getPassword()).isEqualTo(expectedPassword);
        assertThat(all.get(0).getGender()).isEqualTo(expectedGender);
        assertThat(all.get(0).getAge()).isEqualTo(expectedAge);
    }
}
