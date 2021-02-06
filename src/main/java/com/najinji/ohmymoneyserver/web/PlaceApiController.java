package com.najinji.ohmymoneyserver.web;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.najinji.ohmymoneyserver.service.place.PlaceService;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceResponseDto;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceUpdateRequestDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaceApiController {

    private final PlaceService placeService;

    @GetMapping("/api/v1/place")
    public List<PlaceResponseDto> findAll() {
        return placeService.findAll();
    }

    @GetMapping("/api/v1/place/{id}")
    public PlaceResponseDto findById(@PathVariable Long id) {
        return placeService.findById(id);
    }

    @GetMapping("/api/v1/place/search")
    public List<PlaceResponseDto> searchPlaces(@RequestParam(value = "query") String query) {
        return placeService.searchPlaces(query);
    }

    @PostMapping("/api/v1/place")
    public PlaceResponseDto findByName(@RequestBody String place) throws ParseException {
        place = (String)((JSONObject) new JSONParser().parse(place)).get("name");
        return placeService.findByName(place);
    }

    @PutMapping("/api/v1/place/{id}")
    public Long update(@PathVariable Long id, @RequestBody PlaceUpdateRequestDto requestDto) {
        return placeService.update(id, requestDto);
    }

}
