package com.sh.config;

import feign.Contract;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import feign.codec.Encoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 19:18 2018/12/10
 */
@Configuration
public class MultipartSupportConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new FeignSpringFormEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}