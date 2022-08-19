package com.webapp.web.controller;

import com.webapp.dto.LoginRequestDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.webapp.dto.RegisterRequestDto;
import com.webapp.dto.RegisterResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/base")
public class chatRoom {
    //    public static Logger logger = LoggerFactory.getLogger(chatRoom.class);
    public static final String INDEX_JSP = "index";
    public static final String LOGIN_JSP = "index";
    public static final String MAIN_JSP = "main";

    @RequestMapping(value = "/index")
    public String index() {
        return INDEX_JSP;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginRequestDto req) {
        System.out.println(req.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(MAIN_JSP);
        modelAndView.addObject("userName", req.getName());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponseDto register(@RequestBody RegisterRequestDto requestDto) {
        RegisterResponseDto responseDto = new RegisterResponseDto();

        return responseDto;

    }

    @RequestMapping(value = "/doSomeThing")
    public ModelAndView doSomeThing() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
