package com.webapp.web;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect

public @interface TestAOP {
    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public boolean addAop();


}
