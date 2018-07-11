package com.hacker.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/to")
    public String to(){
        return "oa/test";
    }
}
