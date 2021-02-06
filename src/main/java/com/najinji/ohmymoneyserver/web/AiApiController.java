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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    public Map<String, Object> flaskRestApi(@RequestBody String place) throws ParseException {
        String input = place;

        if (place.contains("=")) {
            String[] a = place.split("=");
            String _place = "";
            try {
                _place = URLDecoder.decode(a[1], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            input = "{\n" +
                    "\"name\": " +
                    "\""+ _place+"\"" +
                    "\n}";
        }

        // 플라스크 서버 주소
        String url = "http://ec2-54-180-122-125.ap-northeast-2.compute.amazonaws.com:5000/recommender";

        // http 통신 설정 (json 형태로 contenttype변경 및 post body에 input 삽입)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity param = new HttpEntity(input, headers);

        // flask 서버에 request해서 5개의 추천 명소를 받아옴.
        restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, param, String.class);

        // {"recommended_landmarks" : [ ....] }와 같이 result에 response 값을 받음
        JSONArray jsonArray = (JSONArray)((JSONObject) new JSONParser().parse(result)).get("recommended_landmarks");

        // jsonArray를 가져오는 방식 -> 하나씩 가져와서 저장하는 것말고 한번에 parameter를 넘겨서 받아오는 방식으로 바꿀 것.
        List<String> names = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++)
            names.add((String) jsonArray.get(i));

        // 이름 찾기
        List<PlaceResponseDto> dto = placeService.findByNameIn(names);
        // 사용자 사용 정보 저장
//        ????

        Map<String, Object> results = new HashMap<>();
        results.put("recommended_landmarks", dto);
        return results;
    }
}
