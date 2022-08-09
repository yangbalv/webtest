package com.webapp.web.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.webapp.dto.LoginRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/base")
public class chatRoom {
    //    private static final Logger logger = LoggerFactory.getLogger(chatRoom.class);
    public static final String INDEX_JSP = "index";
    public static final String LOGIN_JSP = "index";
    public static final String MAIN_JSP = "main";

    @RequestMapping(value = "/index")
    public String index() {
        return INDEX_JSP;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginRequestDto req) {
        System.out.println(req.toString());
        return MAIN_JSP;
    }


}
