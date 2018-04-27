package com.imooc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by MAIBENBEN on 2018/1/31.
 * API测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   // 进行api测试必须加
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    // mvn clean package 在打包时进行全部单元测试。
    @Test
    public void getList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}