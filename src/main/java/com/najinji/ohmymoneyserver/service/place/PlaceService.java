package com.najinji.ohmymoneyserver.service.place;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.place.PlaceRepository;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceResponseDto;

@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Transactional
    public Long save(PlaceSaveRequestDto requestDto) {
        return placeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PlaceUpdateRequestDto requestDto) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));
        place.update(requestDto.getName(), requestDto.getAddress(), requestDto.getPhone(), requestDto.getTag());
        return id;
    }

    @Transactional
    public PlaceResponseDto findById(Long id) {
        Place entity = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new PlaceResponseDto(entity);
    }

}
