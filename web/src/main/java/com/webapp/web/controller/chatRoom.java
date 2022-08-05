package com.webapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/base")
public class chatRoom {
    private static final Logger logger = LoggerFactory.getLogger(chatRoom.class);
    public static final String INDEX_JSP = "";
    public static final String LOGIN_JSP = "login";
    public static final String MAIN_JSP = "";

    @RequestMapping(value = "/index")
    public String index() {
        return INDEX_JSP;
    }

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("dwadadwa");
        logger.info("dwadadwa");
        return LOGIN_JSP;
    }


}
