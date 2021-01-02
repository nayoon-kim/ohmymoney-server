package com.najinji.ohmymoneyserver.web.dto;

import lombok.Builder;
import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.users.Users;

@Getter
public class UsersResponseDto {

    private Long id;
    private String name;
    private String loginname;
    private String password;
    private int gender;
    private int age;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.loginname = entity.getLoginname();
        this.password = entity.getPassword();
        this.gender = entity.getGender();
        this.age = entity.getAge();
    }

}
