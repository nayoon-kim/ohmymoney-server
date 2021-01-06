package com.najinji.ohmymoneyserver.web.dto;

import com.najinji.ohmymoneyserver.domain.user.Role;
import com.najinji.ohmymoneyserver.domain.user.User;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String picture;
    private Role role;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
    }
}
