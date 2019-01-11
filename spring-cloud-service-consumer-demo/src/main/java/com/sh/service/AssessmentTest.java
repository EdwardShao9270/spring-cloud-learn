package com.sh.service;

import com.sh.config.FeignConfiguration;
import com.sh.config.MultipartSupportConfig;
import com.sh.model.Account;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 11:38 2018/12/19
 */
@FeignClient(value = "faAccountData",  configuration = {FeignConfiguration.class}, path = "/account")
public interface AssessmentTest {

    @RequestLine("POST /assessments")
    @Headers({"Content-Type: application/json","Accept: application/json"})
    int insert(@Param("account") Account account);
}
