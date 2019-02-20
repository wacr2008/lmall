package com.li.userserver.utils;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author lihaodong
 * @Description Feign配置
 * @Date 11:24 2019/1/17
 * @Param
 * @return
 **/
@Configuration
public class FeignUtil {

    @Bean
    public Retryer feignRetried(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L),5);
    }

}
