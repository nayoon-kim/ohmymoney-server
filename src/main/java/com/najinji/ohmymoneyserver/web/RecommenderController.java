package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.web.dto.HelloResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommenderController {
    @GetMapping("/recommend")
    public String hello() {
        return "hello";
    }

    @GetMapping("/data-recommend")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
