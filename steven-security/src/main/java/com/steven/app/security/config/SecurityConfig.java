package com.steven.app.security.config;

import com.steven.app.security.service.impl.CustomerServiceImpl;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Steven on 2017/4/17.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    UserDetailsService customUserService()
    { //注册UserDetailsService 的bean
        return new CustomerServiceImpl();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests()
                .antMatchers("/", "/public*").permitAll()
                .antMatchers("/users*").hasAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();*/

        http
                .authorizeRequests()
                .antMatchers( "/", "/login","/users/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/userDetail").failureForwardUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

       /* http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
                .fullyAuthenticated().and().formLogin().loginPage("/login")
                .failureUrl("/login?error").and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
                .exceptionHandling().accessDeniedPage("/access?error");*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth
                .userDetailsService(customUserService());*/
        auth
                .userDetailsService(customUserService())
                .passwordEncoder(new Md5PasswordEncoder());
    }

}
