package com.sh.service;

import com.sh.model.AccountImg;
import feign.Response;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
