package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.service.user.UserService;
import com.najinji.ohmymoneyserver.web.dto.UserSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.UserUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PutMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto findById (@PathVariable Long id) {
        return userService.findById(id);
    }
}
