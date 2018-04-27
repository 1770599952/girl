package com.imooc.service;

import com.imooc.exception.GirlException;
import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MAIBENBEN on 2018/1/30.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwoGirl() {

        try {
            Girl girl = new Girl();
            girl.setAge(212);
            girl.setCupSize("F");
            girlRepository.save(girl);
            Girl girl1 = new Girl();
            girl1.setAge(33);
            girl1.setCupSize("FF");
            girlRepository.save(girl1);
            throw new RuntimeException("出异常了，应该回滚");

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("出异常了，应该回滚");

        }
    }

    // 通过年龄查询女生信息
    public void getGirlById(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.AGE_LOWWER);
        }else if(age >= 10 && age <= 18){
            throw new GirlException(ResultEnum.CHILD_ERROR);
        }
    }

    // 查询一个女生
    // 右键 GO TO --》 test 进行单元测试。
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
