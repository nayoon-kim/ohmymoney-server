package com.najinji.ohmymoneyserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebRestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
