package com.webapp.web.controller;




import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class TestConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        return null;
    }
}
