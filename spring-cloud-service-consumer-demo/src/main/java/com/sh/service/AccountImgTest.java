package com.sh.service;

import com.sh.config.FeignConfiguration;
import com.sh.config.MultipartSupportConfig;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 15:46 2018/12/14
 */
@FeignClient(value = "faAccountData",configuration = {FeignConfiguration.class}, path = "/accountImg")
//@Qualifier("accountImgTest")
public interface AccountImgTest {
    //@GetMapping(value = "/status?userName={userName}")
    @RequestLine("GET /status?userName={userName}")
    Integer getStatusByUserName(@Param("userName") String  userName);
}






