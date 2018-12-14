package com.sh.service;

import com.sh.model.AccountImg;
import feign.Param;
import feign.Response;
import feign.hystrix.FallbackFactory;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.RibbonClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 11:33 2018/12/10
 */
@Component
public class HystrixFactory implements FallbackFactory<AccountImgService> {

    @Override
    public AccountImgService create(Throwable throwable) {

       return new AccountImgService(){
           @Override
           public boolean insert(MultipartFile file, MultipartFile file2, AccountImg accountImg) {
               return false;
           }

           @Override
           public Response getImg1(String userName) {
               return null;
           }
       };
    }
}
