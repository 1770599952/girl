package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.properties.GirlProperties;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MAIBENBEN on 2017/11/17.
 */
@Controller
@ResponseBody
public class HelloController {

    // 将yml的配置注入
    @Value("${girl.cupSize}")
    private String cupSize;

    // 在配置文件中使用当前配置进行的注入。
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;
    
    @Autowired
    private GirlRepository girlRepository;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(@CookieValue String cookie) {
        return girlProperties.getCupSize();
    }
    
    @RequestMapping(value = "/responseEntity",method = RequestMethod.GET)
    public ResponseEntity<Girl> entity() {
    	ResponseEntity<Girl> entity = new ResponseEntity<Girl>(girlRepository.findAll().get(0), HttpStatus.OK);
    	return entity;
    }
    
    @RequestMapping(value = "/responseGirl/{id}",method = RequestMethod.GET)
    public Girl entitySimple(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }
}
