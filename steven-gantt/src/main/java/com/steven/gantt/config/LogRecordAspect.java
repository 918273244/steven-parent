package com.steven.gantt.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * logRecord 记录
 * Created by Steven on 2017/4/19.
 */
@Aspect //定义一个切面
@Configuration
public class LogRecordAspect {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义切点pointcut
    @Pointcut("execution( * com.steven.gantt.* .*Controller.*(..))")
//    @Pointcut("execution(public * com.kfit.*.web..*.*(..))")
    public void excudeService() {
    }
    //定义切点pointcut
 /*   @Pointcut("execution(public * com.steven.gantt.*Controller.*(..))")
    public void excudeServiceT() {
    }*/

    @Around("excudeService()")
//    @Around("excudeService() && excudeServiceT()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        logger.info("请求结束，controller的返回值是 " + result);
        return result;
    }
}
