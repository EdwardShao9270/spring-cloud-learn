package com.sh.service;

import com.sh.config.MultipartSupportConfig;
import com.sh.config.SpringMvcContractConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 15:46 2018/12/14
 */
@FeignClient(name = "faAccountData", configuration = SpringMvcContractConfig.class, path = "/accountImg")
public interface AccountImgTest {

    @GetMapping(value = "/status?userName={userName}")
    //@RequestLine("GET /status?userName={userName}")
    Integer getStatusByUserName(@RequestParam("userName") String  userName);
}
