package com.najinji.ohmymoneyserver.service.user;

import com.najinji.ohmymoneyserver.domain.user.User;
import com.najinji.ohmymoneyserver.domain.user.UserRepository;
import com.najinji.ohmymoneyserver.web.dto.user.UserSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.user.UserUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.user.UserResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElse(userRepository.save(requestDto.toEntity()));
        return user.getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id)
                .map(entity -> entity.update(requestDto.getGender(), requestDto.getAge(), requestDto.getResidence()))
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return user.getId();
    }

    @Transactional
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new UserResponseDto(entity);
    }

    @Transactional
    public UserResponseDto findByEmail(String email) {
        User entity = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. email = " + email));
        return new UserResponseDto(entity);
    }
}
