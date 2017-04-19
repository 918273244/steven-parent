package com.steven.gantt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Steven on 2017/4/19.
 */
public class MyAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    public void  init(){

    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("进入方法");
        return super.attemptAuthentication(request, response);
    }
}
