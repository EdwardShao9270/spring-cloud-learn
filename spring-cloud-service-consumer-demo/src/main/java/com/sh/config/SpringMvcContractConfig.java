package com.sh.config;

import feign.Contract;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 16:59 2018/12/14
 */
@Configuration
public class SpringMvcContractConfig {
    @Bean
    public Contract springMvcContract() {
        return new SpringMvcContract();
    }
}
