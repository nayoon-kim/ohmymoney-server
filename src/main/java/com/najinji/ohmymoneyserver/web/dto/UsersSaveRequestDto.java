package com.najinji.ohmymoneyserver.web.dto;

import com.najinji.ohmymoneyserver.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    // Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성함.
    // 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안된다.
    // Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이고, Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다.
    private String name;
    private String loginname;
    private String password;
    private int gender;
    private int age;

    @Builder
    public UsersSaveRequestDto(String name, String loginname, String password, int gender, int age) {
        this.name = name;
        this.loginname = loginname;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .loginname(loginname)
                .password(password)
                .gender(gender)
                .age(age)
                .build();
    }
}
