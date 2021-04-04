package com.najinji.ohmymoneyserver.service.place;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.place.PlaceRepository;
import com.najinji.ohmymoneyserver.domain.redis.redisplace.RedisPlace;
import com.najinji.ohmymoneyserver.domain.redis.redisplace.RedisPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final PlaceRepository placeRepository;
    private final RedisPlaceRepository redisPlaceRepository;
    private WebClient webClient;

    @Scheduled(fixedDelay = 10000)
    public void task1() {
        System.out.println("The current date(1): " + LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 100000)
    public void task2() {
        List<Place> places = placeRepository.findAll();
// = "http://3.36.136.219:5000/recommender";
        String url = "http://3.36.136.219:5000";
        webClient = WebClient.builder().baseUrl(url).build();

        for (Place place: places) {

            String id = place.getName();

            // flask 서버에 request해서 5개의 추천 명소를 받아옴.
            this.webClient
                    .post()
                    .uri("/recommender")
                    .header("name", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe(s -> {
                        System.out.println(s);
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = (JSONArray) ((JSONObject) new JSONParser().parse(s)).get("recommended_landmarks");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        // jsonArray를 가져오는 방식 -> 하나씩 가져와서 저장하는 것말고 한번에 parameter를 넘겨서 받아오는 방식으로 바꿀 것.
                        List<String> recommended_places = new ArrayList<>();
                        for (int i = 0; i < jsonArray.size(); i++)
                            recommended_places.add((String) jsonArray.get(i));

                        RedisPlace redisPlace;
                        if (redisPlaceRepository.findById(id).get() != null) {
                            redisPlace = redisPlaceRepository.findById(id).get();
                            redisPlace.update(recommended_places);
                        } else{
                            redisPlace = RedisPlace.builder()
                                    .id(id)
                                    .places(recommended_places)
                                    .build();
                        }
                        redisPlaceRepository.save(redisPlace);
                        System.out.println(redisPlace);
                    });

        }
    }
}
