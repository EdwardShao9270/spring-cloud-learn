package com.sh.service;

import com.sh.controller.MultipartSupportConfig;

import com.sh.controller.SpringMvcContractConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 15:46 2018/12/14
 */
@FeignClient(value = "faAccountData",configuration = {MultipartSupportConfig.class}, path = "/accountImg")
//@Qualifier("accountImgTest")
public interface AccountImgTest {
    //@GetMapping(value = "/status?userName={userName}")
    @RequestLine("GET /status?userName={userName}")
    Integer getStatusByUserName(@Param("userName") String  userName);
}






