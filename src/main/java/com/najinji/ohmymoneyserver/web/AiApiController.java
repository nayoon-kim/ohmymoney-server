package com.najinji.ohmymoneyserver.web;

import lombok.RequiredArgsConstructor;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.najinji.ohmymoneyserver.web.dto.place.PlaceResponseDto;
import com.najinji.ohmymoneyserver.service.place.PlaceService;

@RequiredArgsConstructor
@RestController
public class AiApiController {

    private RestTemplate restTemplate;
    private final PlaceService placeService;

    @PostMapping("/ai")
    public Map<String, Object> display(@RequestBody String place) throws ParseException {
////        System.out.println(place);
//        String[] a = place.split("=");
//        System.out.println(a[0]);
//        System.out.println(a[1]);
//        String input = "";
//        try {
//            input = ("{\n" +
//                    "\"name\": " +
//                    "\""+ URLEncoder.encode(a[1],"utf-8")+"\"" +
//                    "\n}");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        String url = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(place);
        HttpEntity param = new HttpEntity(place, headers);
//        HttpEntity param = new HttpEntity(place, headers);
        restTemplate = new RestTemplate();

        String result = restTemplate.postForObject(url, param, String.class);

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(result);
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray jsonArray = (JSONArray) jsonObject.get("recommended_landmarks");

        // jsonArray를 가져오는 방식 -> 하나씩 가져와서 저장하는 것말고 한번에 parameter를 넘겨서 받아오는 방식으로 바꿀 것.
        List<Map<String, Object>> places = new ArrayList<>();
        Map<String, Object> results = new HashMap<>();
        for (int i = 0; i < jsonArray.size(); i++){
            PlaceResponseDto dto = placeService.findByName((String) jsonArray.get(i));
            Map<String, Object> map = new HashMap<>();
            map.put("id", dto.getId().toString());
            map.put("name", dto.getName());
            map.put("address", dto.getAddress());
            map.put("phone", dto.getPhone());
            map.put("tag", dto.getTag());

            places.add(map);
        }
        results.put("recommended_landmarks", places);
        return results;
    }
}
