package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.service.users.UsersService;
import com.najinji.ohmymoneyserver.web.dto.users.UsersSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.users.UsersUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.users.UsersResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }
    @GetMapping("/api/v1/users/{id}")
    public UsersResponseDto findById (@PathVariable Long id) {
        return usersService.findById(id);
    }
}
