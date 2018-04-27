package com.imooc.util;

import com.imooc.domain.Result;

/**
 * Created by MAIBENBEN on 2018/1/31.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setMsg("成功！");
        result.setCode(0);
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        result.setData(null);
        return result;
    }
}
