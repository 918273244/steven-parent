package com.steven.gantt.controller;

import com.steven.gantt.entity.User;
import com.steven.gantt.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BasisController
 * Created by Steven on 2017/4/19.
 */
public class BasisController {

    @Resource
    private UserServiceImpl userService;

    public Map<String, Object> getButtonAuth(List<String> authCodeList, Model model, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Map<String, Object> authMap = new HashMap<String, Object>();
        for (String authCode : authCodeList)
        {
            for (GrantedAuthority authority : authorities)
            {
                if (authCode.equals(authority.toString()))
                {
                    authMap.put(authCode, true);
                    break;
                }
            }
        }
        User user = getSessionUser(userDetails.getUsername());
        Map<String, Object> authMapForSideBar = new HashMap<String, Object>();
        for (GrantedAuthority authority : authorities)
        {
            authMapForSideBar.put(authority.toString(), true);
        }
        model.addAttribute("user", user);
        model.addAttribute("nickName", user.getUsername());
        model.addAttribute("authList", authMapForSideBar);
        return authMap;
    }


    private User getSessionUser(String userName)
    {
        return userService.findByUsername(userName);
    }

}
