package com.najinji.ohmymoneyserver.web;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//    @GetMapping("/api/v1/place")
//    public List<PlaceResponseDto> query(HttpServletRequest request) {
//        String q = request.getParameter("q");
//        return placeService.query(q);
//    }

    @PostMapping("/api/v1/place")
    public PlaceResponseDto findByName(@RequestBody String place) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(place);
        JSONObject jsonObject = (JSONObject) obj;

        String _place = (String) jsonObject.get("name");

        return placeService.findByName(_place);
    }

    @PutMapping("/api/v1/place/{id}")
    public Long update(@PathVariable Long id, @RequestBody PlaceUpdateRequestDto requestDto) {
        return placeService.update(id, requestDto);
    }

}
