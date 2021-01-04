package com.najinji.ohmymoneyserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebRestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
