package com.may.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域配置,参考springboot文档 27.1.10
 * Created by May on 3/27/17.
 */
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer crosConfigurer() {

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 对所有/api开始的请求允许跨域
                registry.addMapping("/api/**").allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
                ;
            }
        };

    }

}
