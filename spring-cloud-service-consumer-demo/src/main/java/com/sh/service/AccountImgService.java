package com.sh.service;

import com.sh.config.MultipartSupportConfig;
import com.sh.model.AccountImg;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 14:43 2018/12/7
 */
@FeignClient(name = "faAccountData",  configuration = MultipartSupportConfig.class, path = "/accountImg")
public interface AccountImgService {

/*
    @RequestLine("GET /account/img/get/{userName}?demo={demo}")
    Map<String,Object> get(@Param("userName")String  userName, @Param("demo") String demo);

    @RequestLine("GET /account/img/status?userName={userName}")
    Integer getStatusByUserName(@Param("userName")String  userName);


 /*   @RequestMapping(value = "/accountImg/file1-file2-accountImgInfo", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    boolean insert(@RequestPart("file1") MultipartFile file1,@RequestPart("file2") MultipartFile file2);*/


    @RequestLine("POST /file1-file2-accountImgInfo")
    boolean insert(@Param("file1") MultipartFile file, @Param("file2") MultipartFile file2, @Param("accountImg") AccountImg accountImg);

    @RequestLine("GET /getImg1?userName={userName}")
    Response getImg1(@Param("userName") String userName);
}
