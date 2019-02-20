package com.li.cartserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName CorsConfiguration
 * @Author lihaodong
 * @Date 2019/1/8 16:42
 * @Mail lihaodongmail@163.com
 * @Description 跨域配置
 * @Version 1.0
 **/

@Configuration
public class CrosConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        /**
         * 允许任何域名使用
         * 具体域名使用
         */
        corsConfiguration.addAllowedOrigin("*");
        /**
         * 允许任何头
         */
        corsConfiguration.addAllowedHeader("*");
        /**
         * 允许任何方法（post、get等）
         */
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}
