package com.najinji.ohmymoneyserver.web.dto.user;

import com.najinji.ohmymoneyserver.domain.user.Gender;
import com.najinji.ohmymoneyserver.domain.user.Type;
import com.najinji.ohmymoneyserver.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private Type type;
    private String name;
    private String email;
    private String picture;
    private Gender gender;

    @Builder
    public UserSaveRequestDto(Type type, String name, String email, Gender gender, String picture) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }
    @Builder
    public UserSaveRequestDto(Type type, String name, String email, String picture) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User toEntity() {
        return User.builder()
                .type(type)
                .name(name)
                .email(email)
                .picture(picture)
                .build();
    }
}
