package com.najinji.ohmymoneyserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
    @RequestMapping(value="/login")
    public String login() {
        return "index";
    }
}
