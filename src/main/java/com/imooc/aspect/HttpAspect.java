package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LYJ on 2018/1/31.
 */
@Aspect
@Component
public class HttpAspect {

    // 使用AOP处理请求，并且记录对应的日志
    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);


    // 一.基本切面格式
    // 在com.imooc.controller.GirlController中的所有方法执行之前都会执行
//    @Before("execution(public * com.imooc.controller.GirlController.*(..))")
//    public void logBefore(){
//        log.info("收到HTTP请求！");
//    }
//
//    @After("execution(public * com.imooc.controller.GirlController.*(..))")
//    public void logAfter(){
//        log.info("HTTP请求结束！");
//    }

    // 二.定义切点
  //  @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    @Pointcut("@annotation(com.imooc.annocation.LogAction)")
    public void log(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        log.info("收到HTTP请求！");
        log.info("url={}",request.getRequestURL());
        log.info("method={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        // 获取执行的类名和方法
        log.info("class_method",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        log.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void logAfter(){
        log.info("HTTP请求结束！");
    }

    // 方法执行完返回的内容
    @AfterReturning(returning = "object",pointcut = "log()")
    public void logAfterReturning(Object object){
        log.info("response={}",object.toString());
        log.info("HTTP请求结束！");
    }
}
