package com.najinji.ohmymoneyserver.service.place;

import com.najinji.ohmymoneyserver.domain.redis.redisplace.RedisPlace;
import com.najinji.ohmymoneyserver.domain.redis.redisplace.RedisPlaceRepository;
import lombok.RequiredArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.json.simple.parser.ParseException;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.place.PlaceRepository;
import com.najinji.ohmymoneyserver.domain.place.PlaceQueryRepository;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceUpdateRequestDto;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceResponseDto;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceQueryRepository placeQueryRepository;
    private final RedisPlaceRepository redisPlaceRepository;

    @Transactional
    public Long save(PlaceSaveRequestDto requestDto) {
        return placeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PlaceUpdateRequestDto requestDto) {
        Place place = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        place.update(requestDto.getName(), requestDto.getAddress(), requestDto.getPhone()
                , requestDto.getTag(), requestDto.getUrl(), requestDto.getSum(), requestDto.getDetails()
                , requestDto.getLatitude(), requestDto.getLongitude());
        return id;
    }

    @Transactional
    public PlaceResponseDto findById(Long id) {
        Place entity = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new PlaceResponseDto(entity);
    }

    @Transactional
    public PlaceResponseDto findByName(String name) {
        Place entity = placeRepository.findByName(name);
        return new PlaceResponseDto(entity);
    }

    @Transactional
    public List<PlaceResponseDto> findAll() {
        return placeRepository.findAll().stream().map(PlaceResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<PlaceResponseDto> searchPlaces(String q) {
        return placeRepository.findByNameContaining(q).stream().map(PlaceResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<PlaceResponseDto> findByNameIn(List<String> names) {
        return placeRepository.findByNameIn(names).stream().map(PlaceResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public List<PlaceResponseDto> recommendByFlask(String id) throws ParseException {
        RedisPlace redisPlace = redisPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return placeRepository.findByNameIn(redisPlace.getPlaces()).stream().map(PlaceResponseDto::new).collect(Collectors.toList());
    }
}
