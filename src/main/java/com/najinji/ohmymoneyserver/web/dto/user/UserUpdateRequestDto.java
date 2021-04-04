package com.najinji.ohmymoneyserver.web.dto.user;

import com.najinji.ohmymoneyserver.domain.user.Gender;
import com.najinji.ohmymoneyserver.domain.user.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;
    private String picture;
    private Gender gender;
    private int age;
    private String residence;

    @Builder
    public UserUpdateRequestDto(Gender gender, int age, String residence) {
        this.gender = gender;
        this.age = age;
        this.residence = residence;
    }
}
