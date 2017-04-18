/*
package com.steven.gantt.security;
import com.steven.gantt.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        User userDetails   =  (User)authentication.getPrincipal();
        System.out.println("登录："+userDetails.getUsername());
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
*/
