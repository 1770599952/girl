package com.imooc.handle;

import com.imooc.exception.GirlException;
import com.imooc.aspect.HttpAspect;
import com.imooc.domain.Result;
import com.imooc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MAIBENBEN on 2018/1/31.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException) {
            return ResultUtil.error(((GirlException) e).getCode(), ((GirlException) e).getMessage());
        }
        log.error("系统错误："+e);
        return ResultUtil.error(-1,"未知错误！");
    }
}
