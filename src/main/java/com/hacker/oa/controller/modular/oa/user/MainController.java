package com.hacker.oa.controller.modular.oa.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
    public String main() throws Exception {
        return "main";
    }

}