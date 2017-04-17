package com.steven.gantt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * 静态文件自定义url
 * 不建议使用@EnableWebMvc,
 * Created by Steven on 2017/4/14.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        super.addResourceHandlers(registry);
        super.addResourceHandlers(registry);
    }
}
