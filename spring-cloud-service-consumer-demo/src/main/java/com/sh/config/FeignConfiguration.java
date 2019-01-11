package com.sh.config;

import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 16:05 2018/12/7
 */
@Component
public class FeignConfiguration {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder defaultEncoder() {
        return new JacksonEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}