package com.najinji.ohmymoneyserver.web;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AiApiController {

    private RestTemplate restTemplate;

    @PostMapping("/api/v1/ai")
    public String display() {
        String input = ("{\n" +
                "\"name\": " +
                "경복궁" +
                "}");
        String url = "http://localhost:5000/recommender";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity param = new HttpEntity(input, headers);

//        landmark: name: "경복궁"
        String result = restTemplate.postForObject(url, "경복궁", String.class);

        return result;
    }
}
