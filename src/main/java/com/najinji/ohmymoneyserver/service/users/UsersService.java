package com.najinji.ohmymoneyserver.service.users;

import com.najinji.ohmymoneyserver.domain.users.UsersRepository;

import com.najinji.ohmymoneyserver.web.dto.users.UsersSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.users.UsersUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.users.UsersResponseDto;
import com.najinji.ohmymoneyserver.domain.users.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        users.update(requestDto.getPassword(), requestDto.getGender(), requestDto.getAge());
        return id;
    }

    public UsersResponseDto findById (Long id) {
        Users entity = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new UsersResponseDto(entity);
    }
}
