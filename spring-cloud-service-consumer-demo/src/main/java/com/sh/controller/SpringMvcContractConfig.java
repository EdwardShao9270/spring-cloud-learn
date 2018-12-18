package com.sh.controller;

import feign.Contract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 16:59 2018/12/14
 */
public class SpringMvcContractConfig {

    @Bean
    public SpringMvcContract springMvcContract() {
        return new SpringMvcContract();
    }
}
