package com.najinji.ohmymoneyserver.web.dto.user;

import com.najinji.ohmymoneyserver.domain.user.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;
    private String picture;

    @Builder
    public UserUpdateRequestDto(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }
}
