package com.najinji.ohmymoneyserver.domain.users;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @After
    public void cleanup(){
        usersRepository.deleteAll();
    }

    @Test
    public void 사용자저장_불러오기() {
        //given
        String name = "나윤";
        String loginname = "nayoon";
        String password = "pwnayoon";
        int gender = 1;
        int age = 25;

        usersRepository.save(Users.builder()
        .name(name)
        .loginname(loginname)
        .password(password)
        .gender(gender)
        .age(age)
        .build());

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getName()).isEqualTo(name);
        assertThat(users.getLoginname()).isEqualTo(loginname);
        assertThat(users.getPassword()).isEqualTo(password);
        assertThat(users.getGender()).isEqualTo(gender);
        assertThat(users.getAge()).isEqualTo(age);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021,1,2,0,0,0);
        usersRepository.save(Users.builder()
                .name("김나윤")
                .loginname("nayoon")
                .password("pwnayoon")
                .gender(1)
                .age(25)
                .build());

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);

        System.out.println(">>>>>>>>> createdDate=" + users.getCreatedDate() + ", modifiedDate=" + users.getModifiedDate());

        assertThat(users.getCreatedDate()).isAfter(now);
        assertThat(users.getModifiedDate()).isAfter(now);
    }
}
