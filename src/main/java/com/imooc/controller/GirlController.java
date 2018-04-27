package com.imooc.controller;

import com.imooc.annocation.LogAction;
import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LYJ on 2018/1/30.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    // 查询女生列表
//    当你有如下Accept头：
//
//            ①Accept：text/html,application/xml,application/json
//
//                将按照如下顺序进行produces的匹配 ①text/html ②application/xml ③application/json
//
//            ②Accept：application/xml;q=0.5,application/json;q=0.9,text/html
//
//                将按照如下顺序进行produces的匹配 ①text/html ②application/json ③application/xml
//
//                q参数为媒体类型的质量因子，越大则优先权越高(从0到1)
//
//            ③Accept：*/*,text/*,text/html
//
//                  将按照如下顺序进行produces的匹配 ①text/html ②text/* ③*/*

    @GetMapping(value = "/girls", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Girl> getList() {
        return girlRepository.findAll();
    }

    // 添加女生
    @LogAction("添加女生")
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        // BindingResult 用于校验结果的返回
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    // 添加女生
    @PostMapping(value = "/girls/tran")
    public void girlAddTwo() {
        girlService.addTwoGirl();
    }

    // 信息修改
    // 表单提交方式改为x-www-form-urlencoded
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age,
                           @PathVariable("id") Integer id) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    // 删除女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(id);
    }

    // 根据年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }


    @GetMapping(value = "/girls/id/{id}")
    public Girl getGirlInfo(@PathVariable("id") Integer id) throws Exception {
        return girlRepository.findOne(id);
    }



}
