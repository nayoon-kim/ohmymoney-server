package com.najinji.ohmymoneyserver.domain.users;

import com.najinji.ohmymoneyserver.domain.users.UsersRepository;
import com.najinji.ohmymoneyserver.domain.users.UsersRepositorySupport;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersQueryRepository usersQueryRepository;

    @After
    public void tearDown() throws Exception {
        usersRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "김나윤";
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
        List<Users> result = usersQueryRepository.findByName(name);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getLoginname()).isEqualTo(loginname);
        assertThat(result.get(0).getPassword()).isEqualTo(password);
        assertThat(result.get(0).getGender()).isEqualTo(gender);
        assertThat(result.get(0).getAge()).isEqualTo(age);
    }
}
