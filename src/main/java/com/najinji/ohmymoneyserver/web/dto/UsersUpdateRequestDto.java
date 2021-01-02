package com.najinji.ohmymoneyserver.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {

    private String password;
    private int gender;
    private int age;

    @Builder
    public UsersUpdateRequestDto(String password, int gender, int age) {
        this.password = password;
        this.gender = gender;
        this.age = age;
    }
}
