package com.li.goodsserver;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//通过注解@EnableEurekaClient 表明自己是一个eurekaClient
@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.li.goodsserver.mapper")
public class GoodsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsServerApplication.class, args);
    }

}

