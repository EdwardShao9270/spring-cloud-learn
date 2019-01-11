package com.sh.config;

import com.sh.config.FeignSpringFormEncoder;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import feign.codec.Encoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 19:18 2018/12/10
 */
@Component
public class MultipartSupportConfig {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new FeignSpringFormEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

}
