package com.najinji.ohmymoneyserver.service.user;

import com.najinji.ohmymoneyserver.domain.user.User;
import com.najinji.ohmymoneyserver.domain.user.UserRepository;
import com.najinji.ohmymoneyserver.web.dto.UserSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.UserUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        user.update(requestDto.getName(), requestDto.getPicture());
        return id;
    }

    @Transactional
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new UserResponseDto(entity);
    }
}
