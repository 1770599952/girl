package com.imooc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by MAIBENBEN on 2018/1/29.
 */
@Component
// 我们还可以将配置文件属性注入java类中。见girlProperties
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;
    private String age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
