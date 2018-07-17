package com.hacker.oa.controller.modular.oa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exporlter")
public class ExporlterController {
    @RequestMapping("/activitiEdit")
    public String toActivitiEdit(){
        return "/oa/modeler";
    }
}
