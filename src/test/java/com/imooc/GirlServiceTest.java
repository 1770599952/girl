package com.imooc;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by MAIBENBEN on 2018/1/31.
 */
@RunWith(SpringRunner.class)// 底层采用的死junit
@SpringBootTest // 表示启动整个Springboot工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(16);
        Assert.assertEquals(new Integer(10),girl.getAge());
    }
}
