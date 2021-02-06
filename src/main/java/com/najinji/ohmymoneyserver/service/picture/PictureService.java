package com.najinji.ohmymoneyserver.service.picture;

import com.najinji.ohmymoneyserver.domain.picture.Picture;
import com.najinji.ohmymoneyserver.domain.picture.PictureQueryRepository;
import com.najinji.ohmymoneyserver.domain.picture.PictureRepository;
import com.najinji.ohmymoneyserver.web.dto.picture.PictureResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PictureService {

    private final PictureRepository pictureRepository;
    private final PictureQueryRepository pictureQueryRepository;

    @Transactional
    public PictureResponseDto findById(Long id) {
        Picture entity = pictureRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사진이 없습니다."));
        return new PictureResponseDto(entity);
    }

    @Transactional
    public List<PictureResponseDto> findEachPictureById(List<Long> ids) {
        return pictureRepository.findByIdIn(ids).stream().map(PictureResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<PictureResponseDto> findByPlaceId(Long id) {
        return pictureQueryRepository.findByPlaceId(id).stream().map(PictureResponseDto::new).collect(Collectors.toList());
    }

}